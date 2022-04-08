package com.jef.pearl.controller;

import com.jef.pearl.entity.Customer;
import com.jef.pearl.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/inserir")
    public ResponseEntity<Long> insertCostumer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.insertCustomer(customer),HttpStatus.CREATED);
    }

}
