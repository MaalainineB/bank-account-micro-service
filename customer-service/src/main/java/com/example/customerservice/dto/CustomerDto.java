package com.example.customerservice.dto;

public class CustomerDto {
    private Long customerId;
    private String customerName;
    private String customerFirstName;
    private String customerEmail;

    public CustomerDto() {
    }

    public CustomerDto(Long customerId, String customerName, String customerFirstName, String customerEmail) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerFirstName = customerFirstName;
        this.customerEmail = customerEmail;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
