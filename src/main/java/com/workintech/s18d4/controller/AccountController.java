package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.AccountService;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountResponse> getAll() {
        return accountService.findAll()
                .stream()
                .map(a -> new AccountResponse(a.getId(), a.getAccountName(), a.getMoneyAmount()))
                .toList();
    }

    @GetMapping("/{id}")
    public AccountResponse getById(@PathVariable Long id) {
        Account a = accountService.findById(id);
        return new AccountResponse(a.getId(), a.getAccountName(), a.getMoneyAmount());
    }

    @PostMapping("/{customerId}")
    public Account save(@PathVariable Long customerId, @RequestBody Account account) {
        return accountService.save(account);
    }

    @PutMapping("/{customerId}")
    public Account update(@PathVariable Long customerId, @RequestBody Account account) {
        return accountService.save(account);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        accountService.delete(id);
    }
}
