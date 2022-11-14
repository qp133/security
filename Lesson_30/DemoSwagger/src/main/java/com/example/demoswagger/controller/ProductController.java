package com.example.demoswagger.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {
    @GetMapping
    public String getAll() {
        return "List data";
    }

    @PostMapping()
    public String save() {
        return "Save success";
    }

    @PutMapping()
    public String update() {
        return "Update success";
    }
}
