package com.example.userauthen.service;

import com.example.userauthen.entity.User;
import com.example.userauthen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String taiKhoan) throws UsernameNotFoundException {
        User user = userRepository.findByTaiKhoan(taiKhoan);
        if(user == null) {
            throw new EntityNotFoundException("tai khoan hoac mat khau khong dung");
        }
        String matKhau = user.getMatKhau();
        return new org.springframework.security.core.userdetails.User(taiKhoan, matKhau, Collections.emptyList());
    }
}
