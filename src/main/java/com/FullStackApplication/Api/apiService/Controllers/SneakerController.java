package com.FullStackApplication.Api.apiService.Controllers;


import com.FullStackApplication.Api.domain.Dtos.SneakerRequest;
import com.FullStackApplication.Api.domain.Models.Sneaker;
import com.FullStackApplication.Api.domain.Services.SneakerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@CrossOrigin("*")
@RequestMapping("/sneakers")
public class SneakerController {

    private final SneakerService sneakerService;

    public SneakerController(SneakerService sneakerService) {
        this.sneakerService = sneakerService;
    }


    @GetMapping
    public ResponseEntity<List<Sneaker>> getAll() {
        return ResponseEntity.ok(this.sneakerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sneaker> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.sneakerService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Sneaker> addSneaker(@RequestBody SneakerRequest request){
        return ResponseEntity.ok(this.sneakerService.addSneaker(sneaker));
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
