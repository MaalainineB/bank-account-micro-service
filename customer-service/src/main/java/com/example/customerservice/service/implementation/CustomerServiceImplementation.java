package com.example.customerservice.service.implementation;

import com.example.customerservice.dto.CustomerDto;
import com.example.customerservice.entity.Customer;
import com.example.customerservice.mapper.CustomerMapper;
import com.example.customerservice.repository.CustomerRepository;
import com.example.customerservice.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImplementation(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDto getCustomerByCustomerId(Long CustomerId) {
        Optional<Customer> foundedCustomer = customerRepository.findCustomerByCustomerId(CustomerId);
        if (foundedCustomer.isEmpty()) {
            throw new RuntimeException("Client no existant");
        }
        return customerMapper.toDto(foundedCustomer.get());
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        Optional<List<Customer>> foundedCustomers = customerRepository.findCustomersBy();
        if (foundedCustomers.isEmpty()) {
            throw new RuntimeException("aucun client trouvée");
        }
        return foundedCustomers.get().stream().map(customerMapper::toDto).toList();
    }
}
