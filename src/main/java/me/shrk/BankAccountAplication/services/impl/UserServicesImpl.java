package me.shrk.BankAccountAplication.services.impl;


import me.shrk.BankAccountAplication.exceptions.SameAccountNumber;
import me.shrk.BankAccountAplication.exceptions.SameCardNumber;
import me.shrk.BankAccountAplication.exceptions.UserAlreadyDeleted;
import me.shrk.BankAccountAplication.exceptions.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import me.shrk.BankAccountAplication.dtos.RegisterDTO;
import me.shrk.BankAccountAplication.dtos.UpdateDTO;
import me.shrk.BankAccountAplication.models.User;
import me.shrk.BankAccountAplication.repositories.UserRepository;
import me.shrk.BankAccountAplication.services.UserService;

@Service
public class UserServicesImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public User create(RegisterDTO user) {


        String pass = encoder.encode(user.password());

        User u = new User(user.nome(), user.email(), pass, user.account(), user.card(), user.role());
        String numberAccount = u.getAccount().getNumber();
        String CardNumber = u.getCard().getNumber();
        if(userRepository.existsByAccountNumber(numberAccount)){
            throw new SameAccountNumber();
        }
        if(userRepository.existsByCardNumber(CardNumber)){
            throw new SameCardNumber();
        }

        return userRepository.save(u);
    }

    @Override
    public Boolean update(Long id, UpdateDTO user) {
        User u = userRepository.findById(id).orElse(null);

        if(u != null){
            u.setName(user.name());
            u.setEmail(user.email());
            u.setPassword(encoder.encode(user.password()));

            userRepository.save(u);
            return true;
        }
        throw new UserNotFound("user not found");
    }

    @Override
    public void delete(Long id) {
        User u = userRepository.findById(id).orElse(null);

        if(u == null){
            throw new UserAlreadyDeleted();
        }

        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        User u = userRepository.findById(id).orElse(null);

        if(u == null){
            throw new UserNotFound("User not found");
        }

        return u;

    }

    @Override
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }
    
}
