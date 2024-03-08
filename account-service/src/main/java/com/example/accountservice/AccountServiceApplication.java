package com.example.accountservice;

import com.example.accountservice.builder.AccountBuilder;
import com.example.accountservice.client.CustomerRestClient;
import com.example.accountservice.entity.Account;
import com.example.accountservice.enums.AccountType;
import com.example.accountservice.enums.Currency;
import com.example.accountservice.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final CustomerRestClient customerRestClient;

    public AccountServiceApplication(AccountRepository accountRepository, CustomerRestClient customerRestClient) {
        this.accountRepository = accountRepository;
        this.customerRestClient = customerRestClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final Long[] accountId = {1L};
        customerRestClient.getAllCustomers().forEach(customer -> {
            Account account1 = new AccountBuilder()
                    .withAccountId(accountId[0]++)
                    .withAccountNumber(UUID.randomUUID().toString())
                    .withBalance(Math.random() * 12000)
                    .withAccountType(AccountType.CURRENT_ACCOUNT)
                    .withCurrency(Currency.EUR)
                    .withCreationDate(LocalDate.now())
                    .withCustomerId(customer.getCustomerId())
                    .Build();

            Account account2 = new AccountBuilder()
                    .withAccountId(accountId[0]++)
                    .withAccountNumber(UUID.randomUUID().toString())
                    .withBalance(Math.random() * 64558)
                    .withAccountType(AccountType.SAVING_ACCOUNT)
                    .withCurrency(Currency.EUR)
                    .withCreationDate(LocalDate.now())
                    .withCustomerId(customer.getCustomerId())
                    .Build();

            accountRepository.saveAll(List.of(account1, account2));
        });
    }
}
