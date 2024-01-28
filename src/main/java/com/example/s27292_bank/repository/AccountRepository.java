package com.example.s27292_bank.repository;

import com.example.s27292_bank.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AccountRepository {
    private List<Client> accountList = new ArrayList<>();

    public Client create(Client client) {
        client.setId(accountList.size());
        accountList.add(client);
        return client;
    }

    public List<Client> removeById(Integer id){
        Optional<Client> client = getById(id);
        client.ifPresent(it -> accountList.remove(it));
        return accountList;
    }

    public Optional<Client> getById(Integer id){
        return accountList
                .stream()
                .filter(it -> it.getId().equals(id))
                .findFirst();
    }

    public List<Client> getAll() {
        return accountList;
    }

    public List<Client> removeAll() {
        accountList = new ArrayList<>();
        return accountList;
    }

    public List<Client> getAccsOverBalance(Double balance) {
        return accountList
                .stream()
                .filter(it -> it.getBalance() > balance)
                .collect(Collectors.toList());
    }
}
