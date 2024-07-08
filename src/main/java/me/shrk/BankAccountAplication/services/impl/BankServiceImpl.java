package me.shrk.BankAccountAplication.services.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.shrk.BankAccountAplication.models.Account;
import me.shrk.BankAccountAplication.models.Card;
import me.shrk.BankAccountAplication.models.User;
import me.shrk.BankAccountAplication.repositories.UserRepository;
import me.shrk.BankAccountAplication.services.BankService;

@Service
public class BankServiceImpl implements BankService{
    @Autowired
    private UserRepository repository;

    @Override
    public String deposit(Long id, BigDecimal value) {
        Optional<User> u = repository.findById(id);
        String message ="";
        if(u.isPresent()){
            BigDecimal newValue = u.get().getAccount().getBalance().add(value);
            u.get().getAccount().setBalance(newValue);
            repository.save(u.get());
            message = "success";
            return message;
        }
        message = "fail";
        return message;
    }

    @Override
    public String withdraw(Long id, BigDecimal value) {
        Optional<User> u = repository.findById(id);
        String message = "";
        if(u.isPresent()){
            if(u.get().getAccount().getBalance().compareTo(value)==1){
                BigDecimal newValue = u.get().getAccount().getBalance().subtract(value);
                u.get().getAccount().setBalance(newValue);
                repository.save(u.get());
                message = "success";
                return message;
            }else{
                message = "insufficient";
                return message;
            }
        }
        message = "fail";
        return message;
    }

    @Override
    public Account showAccount(Long id) {
        Optional<User> u = repository.findById(id);
        if(u.isPresent()){
            return u.get().getAccount();
        }
        return null;
    }

    @Override
    public Card showCard(Long id) {
        Optional<User> u = repository.findById(id);
        if(u.isPresent()){
            return u.get().getCard();
        }
        return null;
    }
    
}
