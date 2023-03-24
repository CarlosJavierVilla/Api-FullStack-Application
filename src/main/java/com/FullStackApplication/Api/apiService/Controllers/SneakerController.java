package com.FullStackApplication.Api.apiService.Controllers;


import com.FullStackApplication.Api.domain.Dtos.SneakerRequest;
import com.FullStackApplication.Api.domain.Models.Category;
import com.FullStackApplication.Api.domain.Models.Sneaker;
import com.FullStackApplication.Api.domain.Services.SneakerService;
import com.FullStackApplication.Api.infrastructure.Repositories.ICategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@CrossOrigin("*")
@RequestMapping("/sneakers")
public class SneakerController {

    private final SneakerService sneakerService;
    private final ICategoryRepository categoryRepository;

    public SneakerController(SneakerService sneakerService, ICategoryRepository categoryRepository) {
        this.sneakerService = sneakerService;
        this.categoryRepository = categoryRepository;
    }


    @GetMapping
    public ResponseEntity<List<Sneaker>> getAll() {
        return ResponseEntity.ok(this.sneakerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sneaker> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.sneakerService.findById(id));
    }

    @GetMapping("/highlights")
    public ResponseEntity<List<Sneaker>> findAllHighLights(){
        return ResponseEntity.ok(this.sneakerService.findAllHighLights());
    }

    @GetMapping("category/adult")
    public ResponseEntity<List<Sneaker>> findAdultSneakers(){
        return ResponseEntity.ok(this.sneakerService.findAdultSneakers());
    }

    @GetMapping("category/kid")
    public ResponseEntity<List<Sneaker>> findKidSneakers(){
        return ResponseEntity.ok(this.sneakerService.findKidSneakers());
    }


    @PostMapping
    public ResponseEntity<Sneaker> addSneaker(@RequestBody SneakerRequest request){
        return ResponseEntity.ok(this.sneakerService.addSneaker(request));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        this.sneakerService.deleteById(id);
    }











/*

    @PutMapping("{id}")
    public Sneaker updateById(@PathVariable Long id, @RequestBody Sneaker sneaker){
        return sneakerRepository.updateSneaker(id, sneaker);
    }

    @GetMapping("search")
    public List<Sneaker> searchBy(@RequestParam(required = false) String brand){
        return sneakerRepository.searchBy(brand);
    }
    */



}
