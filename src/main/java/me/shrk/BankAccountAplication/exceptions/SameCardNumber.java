package me.shrk.BankAccountAplication.exceptions;

public class SameCardNumber extends RuntimeException{
    public SameCardNumber (String message){ super(message); }
    public SameCardNumber (){ super(); }
}
