package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer save(Customer customer);
    Customer findById(Long id);
    List<Customer> findAll();
    Customer delete(Long id);
    Customer find(Long id);
}
