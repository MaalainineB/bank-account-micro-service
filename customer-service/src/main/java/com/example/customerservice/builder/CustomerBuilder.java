package com.example.customerservice.builder;

import com.example.customerservice.entity.Customer;

public class CustomerBuilder {
    private Long customerId;
    private String customerName;
    private String customerFirstName;
    private String customerEmail;

    public CustomerBuilder withCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public CustomerBuilder withCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public CustomerBuilder withCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
        return this;
    }

    public CustomerBuilder withCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    public Customer Build() {
        return new Customer(customerId,customerName,customerFirstName,customerEmail);
    }
}
