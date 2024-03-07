package com.example.accountservice.builder;

import com.example.accountservice.dto.AccountDto;
import com.example.accountservice.enums.AccountType;
import com.example.accountservice.enums.Currency;
import com.example.accountservice.model.Customer;

import java.time.LocalDate;

public class AccountDtoBuilder {
    private Long accountId;
    private String accountNumber;
    private double balance;
    private AccountType accountType;
    private Currency currency;
    private LocalDate creationDate;
    private LocalDate lastUpdateDate;
    private Customer customer;
    private Long customerId;

    public AccountDtoBuilder withAccountId(Long accountId) {
        this.accountId = accountId;
        return this;
    }

    public AccountDtoBuilder withAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public AccountDtoBuilder withBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public AccountDtoBuilder withAccountType(AccountType accountType) {
        this.accountType = accountType;
        return this;
    }

    public AccountDtoBuilder withCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public AccountDtoBuilder withCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public AccountDtoBuilder withLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    public AccountDtoBuilder withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public AccountDtoBuilder withCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public AccountDto Build() {
        return new AccountDto(accountId, accountNumber, balance, accountType, currency, creationDate, lastUpdateDate, customer, customerId);
    }
}
