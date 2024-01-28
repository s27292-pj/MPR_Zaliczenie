package com.example.s27292_bank;

import com.example.s27292_bank.model.Client;
import com.example.s27292_bank.model.Currency;
import com.example.s27292_bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class S27292BankApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(S27292BankApplication.class);

        AccountService accountService = context.getBean("accountService", AccountService.class);

        Client client1 = new Client(1, "12345678901", 1000.0, Currency.PLN, "Jan", "Kowalski");
        Client client2 = new Client(2, "12345678902", 2000.0, Currency.EUR, "Adam", "Nowak");
        Client client3 = new Client(3, "12345678903", 3000.0, Currency.USD, "Daniel", "Bielinski");
        accountService.create(client1);
        accountService.create(client2);
        accountService.create(client3);
    }
}
