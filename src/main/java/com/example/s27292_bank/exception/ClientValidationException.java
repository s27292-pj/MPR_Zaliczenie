package com.example.s27292_bank.exception;

public class ClientValidationException extends RuntimeException{
    public ClientValidationException(String message) {
        super(message);
    }
}
