package me.shrk.BankAccountAplication.dtos;

import me.shrk.BankAccountAplication.models.Account;
import me.shrk.BankAccountAplication.models.Card;
import me.shrk.BankAccountAplication.models.UserRoles;

public record RegisterDTO(String email, String nome, String password, UserRoles role, Account account, Card card) {
    
}
