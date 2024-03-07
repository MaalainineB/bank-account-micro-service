package com.example.customerservice.builder;

import com.example.customerservice.dto.CustomerDto;

public class CustomerDtoBuilder {
    private Long customerId;
    private String customerName;
    private String customerFirstName;
    private String customerEmail;

    public CustomerDtoBuilder withCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public CustomerDtoBuilder withCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public CustomerDtoBuilder withCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
        return this;
    }

    public CustomerDtoBuilder withCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    public CustomerDto Build() {
        return new CustomerDto(customerId,customerName,customerFirstName,customerEmail);
    }
}
