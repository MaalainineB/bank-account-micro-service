package com.example.customerservice.controller;

import com.example.customerservice.dto.CustomerDto;
import com.example.customerservice.entity.Customer;
import com.example.customerservice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{CustomerId}")
    ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long CustomerId) {
        try {
            return new ResponseEntity<>(customerService.getCustomerByCustomerId(CustomerId), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    ResponseEntity<List<CustomerDto>> getCustomers() {
        try {
            return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
