package com.FullStackApplication.Api.infrastructure.Repositories;

import com.FullStackApplication.Api.domain.Models.Sneaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ISneakerRepository extends JpaRepository<Sneaker, Long> {
    @Query("select s from Sneaker s where s.highlights = true")
    List<Sneaker> findByHighlightsTrue();

    @Query("select s from Sneaker s where s.category.id = ?1")
    List<Sneaker> findByCategory_Id(Long id);



}