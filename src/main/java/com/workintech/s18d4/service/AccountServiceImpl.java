package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.repository.AccountRepository;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    AccountRepository accountRepository;
    CustomerRepository customerRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    /* @Override
    public Account save(Account account) {
        // Eğer account objesi içinde müşteri varsa ve ID varsa, ilişkiyi kur
        if (account.getCustomer() != null && account.getCustomer().getId() != null) {
            Long customerId = account.getCustomer().getId();
            Customer customer = customerRepository.findById(customerId)
                    .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));
            customer.addAccount(account); // çift yönlü ilişkiyi kur
            account.setCustomer(customer); // tekrar set (güvenlik)
        }
        return accountRepository.save(account);
    } */

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found: " + id));
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account delete(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            accountRepository.delete(account.get());
            return account.get();
        }
        return null;
    }

    @Override
    public Account find(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
    }
}
