package com.department.controller;

import com.department.entity.Department;
import com.department.repository.DepartmentRepository;
import com.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("home")
    public String trangChu(Model model) {
        List<Department> departments = departmentService.getAll();
        model.addAttribute("listDepartment", departments);
        return "index";
    }

    @GetMapping("/department/add")
    public String add() {
        return "department-add";
    }

    @PostMapping("/department/save")
    public String save(@ModelAttribute Department department) {
        departmentRepository.save(department);
        return "redirect:/home";
    }
}
