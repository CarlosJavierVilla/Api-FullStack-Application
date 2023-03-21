package com.FullStackApplication.Api.domain.Services;

import com.FullStackApplication.Api.domain.Dtos.SneakerRequest;
import com.FullStackApplication.Api.domain.Models.Sneaker;
import com.FullStackApplication.Api.infrastructure.Repositories.ICategoryRepository;
import com.FullStackApplication.Api.infrastructure.Repositories.ISneakerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SneakerService {
    private final ISneakerRepository sneakerRepository;
    private final AdminService adminService;
    private final ICategoryRepository categoryRepository;


    public SneakerService(ISneakerRepository sneakerRepository, AdminService adminService, ICategoryRepository categoryRepository) {
        this.sneakerRepository = sneakerRepository;
        this.adminService = adminService;
        this.categoryRepository = categoryRepository;
    }
    public List<Sneaker> findAll(){
        return this.sneakerRepository.findAll();
    }

    public Sneaker findById(Long id) {
        var sneakerOptional = this.sneakerRepository.findById(id);
        if(sneakerOptional.isEmpty()) throw new RuntimeException("The product with id: " + id + " doesn't exist in our Data Base. Please try again with other id.");
        return sneakerOptional.get();
    }
    public Sneaker addSneaker(SneakerRequest request) {
        var category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("This category doesn't exist. Please try again."));
        var admin = this.adminService.getAdminRegistered();
        var sneaker = new Sneaker();
        sneaker.setBrand(request.getBrand());
        sneaker.setModel(request.getModel());
        sneaker.setPrice(request.getPrice());
        sneaker.setImg(request.getImg());
        sneaker.setDescription(request.getDescription());
        sneaker.setHighlights(request.getHighlights());
        sneaker.setCategory(category);
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
