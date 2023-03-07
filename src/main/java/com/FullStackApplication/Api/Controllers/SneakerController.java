package com.FullStackApplication.Api.Controllers;


import com.FullStackApplication.Api.models.Sneaker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sneakers")
public class SneakerController {

    List<Sneaker> sneakerDB = new ArrayList<>(
            List.of(
                    new Sneaker(0, "Adidas", "Yeezy 200", 300),
                    new Sneaker(1, "Jordan", "1 High", 290),
                    new Sneaker(2, "Nike", "Dunk Low", 140)
            )
    );

    @GetMapping("/check") // Just a checking
    public String check() {
        return "ok";
    }

    @GetMapping
    public List<Sneaker> getAll() {
        return this.sneakerDB;
    }

    @GetMapping("/{id}")
    public Sneaker getById(@PathVariable long id) {
        return this.sneakerDB.stream()
              .filter(item -> item.getId() == id)
              .findFirst().get();
    }

    @PostMapping
    public Sneaker create(@RequestBody Sneaker sneaker) {
        this.sneakerDB.add(sneaker);
        return sneaker;

    }

}
