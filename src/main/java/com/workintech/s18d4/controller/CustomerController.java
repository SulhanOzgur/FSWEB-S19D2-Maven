package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customer")
public class CustomerController {

private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //Normalde bu Response'a dönüştürme işlemini servicede yapmak lazım, controller sade olmalı
    @GetMapping
    public List<CustomerResponse> getAll() {
        return customerService.findAll()
                .stream()
                .map(c -> new CustomerResponse(c.getId(), c.getEmail(), c.getSalary()))
                .toList();
    }

    @GetMapping("/{id}")
    public CustomerResponse getById(@PathVariable Long id) {
        Customer c = customerService.findById(id);
        return new CustomerResponse(c.getId(), c.getEmail(), c.getSalary());
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        customerService.delete(id);
    }

}
