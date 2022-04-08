package com.jef.pearl.service;

import com.jef.pearl.entity.Customer;
import com.jef.pearl.repository.CustomerRepository;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Long insertCustomer(Customer customer) {

        Customer customerAux = new Customer(customer.getFirstName(), customer.getCpf());
        customer.getJewels().forEach(customerAux::addJewel);

        return customerRepository.save(customerAux).getId();
    }
}
