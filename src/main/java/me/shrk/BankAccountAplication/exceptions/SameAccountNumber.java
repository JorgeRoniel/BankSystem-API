package me.shrk.BankAccountAplication.exceptions;

public class SameAccountNumber extends RuntimeException {
    public SameAccountNumber(String message){ super(message);}

    public SameAccountNumber(){super();}
}
