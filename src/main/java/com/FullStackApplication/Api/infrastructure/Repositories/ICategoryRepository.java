package com.FullStackApplication.Api.infrastructure.Repositories;

import com.FullStackApplication.Api.domain.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
