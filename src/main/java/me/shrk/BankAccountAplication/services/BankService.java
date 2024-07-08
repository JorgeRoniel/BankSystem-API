package me.shrk.BankAccountAplication.services;

import java.math.BigDecimal;

import me.shrk.BankAccountAplication.models.Account;
import me.shrk.BankAccountAplication.models.Card;

public interface BankService {
    
    public String deposit(Long id, BigDecimal value);
    public String withdraw(Long id, BigDecimal value);
    public Account showAccount(Long id);
    public Card showCard(Long id);
}
