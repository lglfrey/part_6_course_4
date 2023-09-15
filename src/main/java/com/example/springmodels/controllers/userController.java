package com.example.springmodels.controllers;

import com.example.springmodels.models.Employee;
import com.example.springmodels.models.modelUser;
import com.example.springmodels.models.roleEnum;
import com.example.springmodels.repos.DepartmentRepository;
import com.example.springmodels.repos.EmployeeRepository;
import com.example.springmodels.repos.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.context.support.BeanDefinitionDsl.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN', 'MANAGER')")
public class userController {

    @Autowired
    private EmployeeRepository employeeRepository;


    @GetMapping("/employee")
    public String employeeMain(Model model)
    {
        Iterable<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employee-main";
    }
}
