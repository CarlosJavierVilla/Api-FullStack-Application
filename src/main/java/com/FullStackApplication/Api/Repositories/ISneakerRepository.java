package com.FullStackApplication.Api.Repositories;

import com.FullStackApplication.Api.Models.Sneaker;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

public interface ISneakerRepository {
    List<Sneaker> findAll();

    Sneaker findById(UUID id);

    Sneaker createSneaker(Sneaker sneaker);

    Sneaker deleteSneaker(UUID id);

    Sneaker updateSneaker(UUID id, Sneaker sneaker);

    // Arreglar
    List<Sneaker> searchBy(@RequestParam(required = false) String brand);
}
