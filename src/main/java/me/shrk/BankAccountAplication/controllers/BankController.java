package me.shrk.BankAccountAplication.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.shrk.BankAccountAplication.models.Account;
import me.shrk.BankAccountAplication.models.Card;
import me.shrk.BankAccountAplication.services.BankService;

@RestController
@RequestMapping("/account")
@SuppressWarnings("rawtypes")
public class BankController {
    @Autowired
    private BankService service;

    
    @PostMapping("/deposit/{id}")
    public ResponseEntity deposit(@PathVariable("id") Long id, @RequestBody BigDecimal value){
        if(service.deposit(id, value) == "success"){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/withDraw/{id}")
    public ResponseEntity withdraw(@PathVariable("id") Long id, @RequestBody BigDecimal value){
        if(service.withdraw(id, value) == "success"){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().body("insuficient funds");
        }
    }

    @GetMapping("/showAccount/{id}")
    public ResponseEntity<Account> showAccount(@PathVariable("id") Long id){
        Account account = service.showAccount(id);
        if(account == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(account);
    }

    @GetMapping("/showCard/{id}")
    public ResponseEntity<Card> showCard(@PathVariable("id") Long id){
        Card card = service.showCard(id);
        if(card == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(card);
    }
}
