package com.example.s27292_bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Client {
    private Integer id;
    private String pesel;
    private Double balance;
    private Currency currency;
    private String name;
    private String surname;
}
