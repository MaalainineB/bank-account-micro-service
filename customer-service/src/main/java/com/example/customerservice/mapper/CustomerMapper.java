package com.example.customerservice.mapper;

import com.example.customerservice.builder.CustomerBuilder;
import com.example.customerservice.builder.CustomerDtoBuilder;
import com.example.customerservice.dto.CustomerDto;
import com.example.customerservice.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDto toDto(Customer customer) {
        return new CustomerDtoBuilder().withCustomerId(customer.getCustomerId())
                .withCustomerName(customer.getCustomerName())
                .withCustomerFirstName(customer.getCustomerFirstName())
                .withCustomerEmail(customer.getCustomerEmail())
                .Build();
    }

    public Customer toCustomer(CustomerDto customerDto) {
        return new CustomerBuilder()
                .withCustomerId(customerDto.getCustomerId())
                .withCustomerName(customerDto.getCustomerName())
                .withCustomerFirstName(customerDto.getCustomerFirstName())
                .withCustomerEmail(customerDto.getCustomerEmail())
                .Build();
    }
}
