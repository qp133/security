package com.example.demothymeleafsecurity.controller;

import com.example.demothymeleafsecurity.entity.Product;
import com.example.demothymeleafsecurity.repository.ProductRepository;
import com.example.demothymeleafsecurity.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("home")
    public String trangChu(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("listProduct", products);
        return "index";
    }

    @GetMapping("product-add")
    public String add() {
        return "product-add";
    }

    @PostMapping("product/save")
    public String save(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/home";
    }
}
