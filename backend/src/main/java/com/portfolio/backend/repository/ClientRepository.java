package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.backend.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Long>{

}
