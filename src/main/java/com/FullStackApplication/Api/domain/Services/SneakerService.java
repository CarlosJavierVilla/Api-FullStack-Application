package com.FullStackApplication.Api.domain.Services;

import com.FullStackApplication.Api.domain.Models.Admin;
import com.FullStackApplication.Api.domain.Models.Sneaker;
import com.FullStackApplication.Api.infrastructure.Repositories.IAdminRepository;
import com.FullStackApplication.Api.infrastructure.Repositories.ISneakerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SneakerService {
    private final ISneakerRepository sneakerRepository;
    private final AdminService adminService;


    public SneakerService(ISneakerRepository sneakerRepository, AdminService adminService) {
        this.sneakerRepository = sneakerRepository;
        this.adminService = adminService;
    }
    public List<Sneaker> findAll(){
        return this.sneakerRepository.findAll();
    }

    public Sneaker findById(Long id) {
        var sneakerOptional = this.sneakerRepository.findById(id);
        if(sneakerOptional.isEmpty()) throw new RuntimeException("The product with id: " + id + " doesn't exist in our Data Base. Please try again with other id.");
        return sneakerOptional.get();
    }

    public Sneaker addSneaker(Sneaker sneaker) {
        var admin = this.adminService.getAdminRegistered();
        sneaker.setAdmin(admin);
        return this.sneakerRepository.save(sneaker);
    }


    public void deleteById(Long sneakerId) {
        var admin = this.adminService.getAdminRegistered();
        var sneaker = sneakerRepository.findById(sneakerId).get();
        if (!admin.equals(sneaker.getAdmin())) throw new RuntimeException("Not authorized");
        this.sneakerRepository.deleteById(sneakerId);
    }
}
