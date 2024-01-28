package com.example.s27292_bank.exception;

public class InvalidPeselException extends RuntimeException {
    public InvalidPeselException(String message) {
        super(message);
    }
}
