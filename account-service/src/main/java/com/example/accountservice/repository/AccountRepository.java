package com.example.accountservice.repository;

import com.example.accountservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {

    Optional<Account> findAccountByAccountId(Long accountId);
    Optional<List<Account>> findAccountsBy();
}
