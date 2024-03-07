package com.example.accountservice.service;

import com.example.accountservice.dto.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto getAccountById(Long accountId);
    List<AccountDto> getAllAccounts();
}
