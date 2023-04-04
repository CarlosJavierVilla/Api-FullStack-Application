package com.FullStackApplication.Api.apiService.Controllers;

import com.FullStackApplication.Api.domain.Models.Admin;
import com.FullStackApplication.Api.domain.Models.Category;
import com.FullStackApplication.Api.domain.Services.AdminService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/sneakers")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admins")
    public List<Admin> findAllAdmins(){
        return adminService.findAllAdmins();
    }
}
