package com.qp.demospecification.controller;

import com.qp.demospecification.entity.Account;
import com.qp.demospecification.repository.AccountRepository;
import com.qp.demospecification.specification.AccountSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("account/search")
    public List<Account> search(@RequestParam(required = false) String username,
                                @RequestParam(required = false) Integer minId) {
        Specification<Account> specification = AccountSpecification.buildWhere(username);
        List<Account> accounts =  accountRepository.findAll(specification);
        return accounts;
    }
}