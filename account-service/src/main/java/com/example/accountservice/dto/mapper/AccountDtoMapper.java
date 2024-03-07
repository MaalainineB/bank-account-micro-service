package com.example.accountservice.dto.mapper;

import com.example.accountservice.builder.AccountBuilder;
import com.example.accountservice.builder.AccountDtoBuilder;
import com.example.accountservice.dto.AccountDto;
import com.example.accountservice.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoMapper {

    public AccountDto toDto(Account account) {
        return new AccountDtoBuilder()
                .withAccountId(account.getAccountId())
                .withAccountNumber(account.getAccountNumber())
                .withBalance(account.getBalance())
                .withAccountType(account.getAccountType())
                .withCurrency(account.getCurrency())
                .withCreationDate(account.getCreationDate())
                .withLastUpdateDate(account.getLastUpdateDate())
                .withCustomer(account.getCustomer())
                .withCustomerId(account.getCustomerId())
                .Build();
    }

    public Account toAccount(AccountDto accountDto) {
        return new AccountBuilder()
                .withAccountId(accountDto.getAccountId())
                .withAccountNumber(accountDto.getAccountNumber())
                .withBalance(accountDto.getBalance())
                .withAccountType(accountDto.getAccountType())
                .withCurrency(accountDto.getCurrency())
                .withCreationDate(accountDto.getCreationDate())
                .withLastUpdateDate(accountDto.getLastUpdateDate())
                .withCustomer(accountDto.getCustomer())
                .withCustomerId(accountDto.getCustomerId())
                .Build();
    }
}
