package com.example.s27292_bank.controller;

import com.example.s27292_bank.service.AccountService;
import com.example.s27292_bank.model.Client;
import com.example.s27292_bank.exception.ClientValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAll() {
        try {
            List<Client> all = accountService.getAll();
            return ResponseEntity.status(200).body(all);
        } catch (ClientValidationException clientValidationException){
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Client> create(@RequestBody Client client) {
        try {
            Client created = accountService.create(client);
            return ResponseEntity.status(201).body(created);
        } catch (ClientValidationException clientValidationException){
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<Client> getById(@RequestParam Integer id) {
        try {
            Client client = accountService.getById(id);
            return ResponseEntity.status(200).body(client);
        } catch (ClientValidationException clientValidationException){
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/removeById")
    public ResponseEntity<List<Client>> removeById(@RequestParam Integer id) {
        try {
            List<Client> clients = accountService.removeById(id);
            return ResponseEntity.status(200).body(clients);
        } catch (ClientValidationException clientValidationException){
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/getAccsOverBalance")
    public ResponseEntity<List<Client>> getAccsOverBalance(@RequestParam Double balance) {
        try {
            List<Client> clients = accountService.getAccsOverBalance(balance);
            return ResponseEntity.status(200).body(clients);
        } catch (ClientValidationException clientValidationException){
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("/removeAll")
    public ResponseEntity<List<Client>> removeAll() {
        try {
            List<Client> clients = accountService.removeAll();
            return ResponseEntity.status(200).body(clients);
        } catch (ClientValidationException clientValidationException){
            return ResponseEntity.status(404).body(null);
        }
    }
}
