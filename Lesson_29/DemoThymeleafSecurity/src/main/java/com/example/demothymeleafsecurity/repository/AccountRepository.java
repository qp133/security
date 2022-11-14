package com.example.demothymeleafsecurity.repository;

import com.example.demothymeleafsecurity.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUserName(String username);
}