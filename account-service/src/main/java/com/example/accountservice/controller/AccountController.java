package com.example.accountservice.controller;

import com.example.accountservice.client.CustomerRestClient;
import com.example.accountservice.dto.AccountDto;
import com.example.accountservice.model.Customer;
import com.example.accountservice.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;
    private final CustomerRestClient customerRestClient;

    public AccountController(AccountService accountService, CustomerRestClient customerRestClient) {
        this.accountService = accountService;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long accountId) {
        try {
            AccountDto foundedAccount = accountService.getAccountById(accountId);
            Customer customerAssociatedToFoundedAccount = customerRestClient.getCustomerById(foundedAccount.getCustomerId());
            foundedAccount.setCustomer(customerAssociatedToFoundedAccount);
            return new ResponseEntity<>(foundedAccount, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping()
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        try {
            List<AccountDto> foundedAccounts = accountService.getAllAccounts();
            foundedAccounts.forEach(foundedAccount -> foundedAccount.setCustomer(customerRestClient.getCustomerById(foundedAccount.getCustomerId())));
            return new ResponseEntity<>(foundedAccounts, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
