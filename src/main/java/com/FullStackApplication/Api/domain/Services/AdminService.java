package com.FullStackApplication.Api.domain.Services;

import com.FullStackApplication.Api.domain.Models.Admin;
import com.FullStackApplication.Api.infrastructure.Repositories.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private IAdminRepository adminRepository;

    Admin getAdminRegistered(){
        return this.adminRepository.findById(1L).get();
    }

    public List<Admin> findAllAdmins(){
        return adminRepository.findAll();
    }
}
