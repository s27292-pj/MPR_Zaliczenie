package com.example.s27292_bank.service;


import com.example.s27292_bank.exception.ClientValidationException;
import com.example.s27292_bank.exception.InvalidPeselException;
import com.example.s27292_bank.model.Client;
import com.example.s27292_bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Client create(Client client) {
        if (client.getPesel().length() != 11) {
            throw new InvalidPeselException("Pesel must be 11 digits long");
        }
        if (client.getBalance() < 0) {
            throw new ClientValidationException("Balance cannot be negative");
        }
        if (client.getPesel().isBlank()) {
            throw new ClientValidationException("Pesel cannot be blank");
        }
        if (client.getBalance().isNaN()) {
            throw new ClientValidationException("Balance cannot be null");
        }
        if (client.getCurrency() == null) {
            throw new ClientValidationException("Currency cannot be null");
        }
        if (client.getName() == null || client.getName().isBlank()) {
            throw new ClientValidationException("Name cannot be null or blank");
        }
        if (client.getSurname() == null || client.getSurname().isBlank()) {
            throw new ClientValidationException("Surname cannot be null or blank");
        }

        return accountRepository.create(client);
    }
    public Client getById(Integer id) {
        if (id == null) {
            throw new ClientValidationException("Id cannot be null");
        }
        return accountRepository.getById(id)
                .orElseThrow(() -> new ClientValidationException("Client with id: " + id + " does not exist"));
    }
    public List<Client> removeById(Integer id) {
        if (id == null) {
            throw new ClientValidationException("Id cannot be null");
        }
        return accountRepository.removeById(id);
    }
    public List<Client> getAccsOverBalance(Double balance) {
        if (balance < 0) {
            throw new ClientValidationException("Balance cannot be negative");
        }
        return accountRepository.getAccsOverBalance(balance);
    }

    public List<Client> getAll() {
        return accountRepository.getAll();
    }

    public List<Client> removeAll() {
        return accountRepository.removeAll();
    }

}
