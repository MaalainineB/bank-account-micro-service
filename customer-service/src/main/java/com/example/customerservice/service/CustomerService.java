package com.example.customerservice.service;

import com.example.customerservice.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto getCustomerByCustomerId(Long CustomerId);

    List<CustomerDto> getAllCustomers();
}
