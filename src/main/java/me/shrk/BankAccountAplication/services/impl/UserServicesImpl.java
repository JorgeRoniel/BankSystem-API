package me.shrk.BankAccountAplication.services.impl;


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
        String CardNmber = u.getCard().getNumber();
        if(userRepository.existsByAccountNumber(numberAccount)){
            return null;
        }
        if(userRepository.existsByCardNumber(CardNmber)){
            return null;
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
        return false;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }
    
}
