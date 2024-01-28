package com.example.s27292_bank.controller;

import com.example.s27292_bank.model.Client;
import com.example.s27292_bank.model.Currency;
import com.example.s27292_bank.repository.AccountRepository;
import com.example.s27292_bank.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AccountControllerTest {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;

    @Test
    void getAll() {
        assertEquals(accountRepository.getAll(), accountService.getAll());
    }
    @Test
    void create() {
        Client client = new Client(1, "12345678901", 1000.0, Currency.PLN, "Jan", "Kowalski");
        assertEquals(accountRepository.create(client), accountService.create(client));
    }
    @Test
    void getAccsOverBalance() {
        assertEquals(accountRepository.getAccsOverBalance(1000.0), accountService.getAccsOverBalance(1000.0));
    }
}