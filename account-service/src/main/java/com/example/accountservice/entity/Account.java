package com.example.accountservice.entity;

import com.example.accountservice.enums.AccountType;
import com.example.accountservice.enums.Currency;
import com.example.accountservice.model.Customer;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Account {
    @Id
    private Long accountId;
    private String accountNumber;
    private double balance;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private LocalDate creationDate;
    private LocalDate lastUpdateDate;

    @Transient
    private Customer customer;
    private Long customerId;

    public Account() {
    }

    public Account(Long accountId, String accountNumber, double balance, AccountType accountType, Currency currency, LocalDate creationDate, LocalDate lastUpdateDate, Customer customer, Long customerId) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.currency = currency;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.customer = customer;
        this.customerId = customerId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
