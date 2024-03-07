package com.example.customerservice;

import com.example.customerservice.builder.CustomerBuilder;
import com.example.customerservice.config.GlobalConfig;
import com.example.customerservice.entity.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public CustomerServiceApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Customer customer1 = new CustomerBuilder()
                .withCustomerName("DOE")
                .withCustomerFirstName("John")
                .withCustomerEmail("john-doe@email.com")
                .Build();

        Customer customer2 = new CustomerBuilder()
                .withCustomerName("Smith")
                .withCustomerFirstName("Jack")
                .withCustomerEmail("jack-smith@email.com")
                .Build();

        customerRepository.saveAll(List.of(customer1,customer2));
    }
}
