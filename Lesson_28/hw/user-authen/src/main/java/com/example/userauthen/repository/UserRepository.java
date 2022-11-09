package com.example.userauthen.repository;

import com.example.userauthen.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByTaiKhoan(String taiKhoan);
}