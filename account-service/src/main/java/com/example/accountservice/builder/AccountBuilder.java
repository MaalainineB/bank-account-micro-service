package com.example.accountservice.builder;

import com.example.accountservice.entity.Account;
import com.example.accountservice.enums.AccountType;
import com.example.accountservice.enums.Currency;
import com.example.accountservice.model.Customer;

import java.time.LocalDate;

public class AccountBuilder {
    private Long accountId;
    private String accountNumber;
    private double balance;
    private AccountType accountType;
    private Currency currency;
    private LocalDate creationDate;
    private LocalDate lastUpdateDate;
    private Customer customer;
    private Long customerId;

    public AccountBuilder withAccountId(Long accountId) {
        this.accountId = accountId;
        return this;
    }

    public AccountBuilder withAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public AccountBuilder withBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public AccountBuilder withAccountType(AccountType accountType) {
        this.accountType = accountType;
        return this;
    }

    public AccountBuilder withCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public AccountBuilder withCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public AccountBuilder withLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    public AccountBuilder withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public AccountBuilder withCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public Account Build() {
        return new Account(accountId, accountNumber, balance, accountType, currency, creationDate, lastUpdateDate, customer, customerId);
    }
}
