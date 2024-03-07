package com.example.accountservice.client;

import com.example.accountservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/customers/{customerId}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer getCustomerById(@PathVariable Long customerId);

    @GetMapping("/customers")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomers")
    List<Customer> getAllCustomers();

    default Customer getDefaultCustomer(Long customerId, Exception exception) {
        Customer defaultCustomer = new Customer();
        defaultCustomer.setCustomerId(customerId);
        defaultCustomer.setCustomerName("néant");
        defaultCustomer.setCustomerFirstName("néant");
        defaultCustomer.setCustomerEmail("néant");
        return defaultCustomer;
    }

    default List<Customer> getDefaultCustomers(Exception exception) {
        return List.of();
    }
}
