package com.example.demothymeleafsecurity.service;

import com.example.demothymeleafsecurity.entity.Account;
import com.example.demothymeleafsecurity.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUserName(username);
        if(account == null) {
            throw new EntityNotFoundException("User or password not found");
        }
        String password = account.getPassword();
        return new User(username, password, AuthorityUtils.createAuthorityList(account.getRole()));
    }
}
