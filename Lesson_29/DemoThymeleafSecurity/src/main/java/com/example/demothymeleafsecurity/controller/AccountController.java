package com.example.demothymeleafsecurity.controller;

import com.example.demothymeleafsecurity.entity.Account;
import com.example.demothymeleafsecurity.entity.Product;
import com.example.demothymeleafsecurity.repository.AccountRepository;
import com.example.demothymeleafsecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("account-add")
    public String add() {
        return "account-add";
    }

    @PostMapping("account/save")
    public String save(@ModelAttribute Account account) {
        account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt(12)));
        accountRepository.save(account);
        return "redirect:/home";
    }
}
