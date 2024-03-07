package com.example.accountservice.service.implementation;

import com.example.accountservice.dto.AccountDto;
import com.example.accountservice.dto.mapper.AccountDtoMapper;
import com.example.accountservice.entity.Account;
import com.example.accountservice.repository.AccountRepository;
import com.example.accountservice.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImplementation implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountDtoMapper accountDtoMapper;

    public AccountServiceImplementation(AccountRepository accountRepository, AccountDtoMapper accountDtoMapper) {
        this.accountRepository = accountRepository;
        this.accountDtoMapper = accountDtoMapper;
    }

    @Override
    public AccountDto getAccountById(Long accountId) {
        Optional<Account> foundedAccount = accountRepository.findAccountByAccountId(accountId);
        if (foundedAccount.isEmpty()) {
            throw new RuntimeException("compte non existant");
        }
        return accountDtoMapper.toDto(foundedAccount.get());
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        Optional<List<Account>> foundedAccounts = accountRepository.findAccountsBy();
        if (foundedAccounts.isEmpty()) {
            throw new RuntimeException("Aucun compte trouvé");
        }
        return foundedAccounts.get().stream().map(accountDtoMapper::toDto).toList();
    }
}
