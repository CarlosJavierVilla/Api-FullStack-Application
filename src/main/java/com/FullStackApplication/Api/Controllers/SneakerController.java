package com.FullStackApplication.Api.Controllers;


import com.FullStackApplication.Api.Models.Sneaker;
import com.FullStackApplication.Api.Repositories.ISneakerRepository;
import com.FullStackApplication.Api.Repositories.SneakerInMemoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@CrossOrigin("*")
@RequestMapping("/sneakers")
public class SneakerController {

    private final ISneakerRepository sneakerInMemoryRepository;

    public SneakerController(ISneakerRepository sneakerInMemoryRepository) {
        this.sneakerInMemoryRepository = sneakerInMemoryRepository;
    }

    @GetMapping
    public List<Sneaker> getAll() {
        return this.sneakerInMemoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Sneaker getById(@PathVariable UUID id) {
        return this.sneakerInMemoryRepository.findById(id);
    }

    /*
    @GetMapping("/{id}")
    public ResponseEntity<Sneaker> getById(@PathVariable UUID id) {

         var sneakerOptional = this.sneakerDB.stream()
              .filter(item -> item.getId().equals(id))
              .findFirst();

        if(sneakerOptional.isEmpty()) return  ResponseEntity.notFound().build();
        return new ResponseEntity<>(sneakerOptional.get(), HttpStatus.OK);

    }*/


    @PostMapping
    public Sneaker create(@RequestBody Sneaker sneaker) {
        return sneakerInMemoryRepository.createSneaker(sneaker);
    }


    @DeleteMapping("{id}")
    public Sneaker deleteById(@PathVariable UUID id){
        return sneakerInMemoryRepository.deleteSneaker(id);
    }
    @PutMapping("{id}")
    public Sneaker updateById(@PathVariable UUID id, @RequestBody Sneaker sneaker){
        return sneakerInMemoryRepository.updateSneaker(id, sneaker);
    }



    // Arreglar
    @GetMapping("search")
    public List<Sneaker> searchBy(@RequestParam(required = false) String brand){
        return sneakerInMemoryRepository.searchBy(brand);
    }


}
