package com.FullStackApplication.Api.infrastructure.Repositories;

import com.FullStackApplication.Api.domain.Models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {

}
