package com.example.s27292_bank.service;



import com.example.s27292_bank.model.Client;
import com.example.s27292_bank.model.Currency;
import com.example.s27292_bank.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceTest {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;

    @Test
    void create() {
        Client client = new Client(1, "12345678901", 1000.0, Currency.PLN, "Jan", "Kowalski");
        Client created = accountService.create(client);
        assertEquals(client, created);
    }
    @Test
    void getById() {
        Client client = new Client(1, "1234567890111", 1000.0, Currency.PLN, "Jan", "Kowalski");
        accountService.create(client);
        Client found = accountService.getById(1);
        assertEquals(client, found);
    }
}