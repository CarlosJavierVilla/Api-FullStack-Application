package com.FullStackApplication.Api.infrastructure.Repositories;

import com.FullStackApplication.Api.domain.Models.Sneaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISneakerRepository extends JpaRepository<Sneaker, Long> {


}