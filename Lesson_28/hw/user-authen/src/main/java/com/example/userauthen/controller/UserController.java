package com.example.userauthen.controller;

import com.example.userauthen.entity.Address;
import com.example.userauthen.entity.User;
import com.example.userauthen.repository.AddressRepository;
import com.example.userauthen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping("user")
    public ResponseEntity<?> save (@RequestBody User user) {
        user.setTaiKhoan(user.getTaiKhoan());
        String passwordEn = BCrypt.hashpw(user.getMatKhau(), BCrypt.gensalt(12));
        user.setMatKhau(passwordEn);
        user.setEmail(user.getEmail());
        user.setHoTen(user.getHoTen());
        user.setSoDienThoai(user.getSoDienThoai());
        user.setIsActive(user.getIsActive());
        userRepository.save(user);
        return new ResponseEntity<>("Save successful", HttpStatus.CREATED);
    }

    @GetMapping("/address")
    public ResponseEntity<?> getListAddress (){
        List<Address> addresses = addressRepository.findAll();
        return ResponseEntity.ok(addresses);
    }

    @PostMapping("address")
    public ResponseEntity<?> saveAddress (@RequestBody Address address) {
        address.setDiaChi(address.getDiaChi());

        addressRepository.save(address);
        return new ResponseEntity<>("Save successful", HttpStatus.CREATED);
    }
}
