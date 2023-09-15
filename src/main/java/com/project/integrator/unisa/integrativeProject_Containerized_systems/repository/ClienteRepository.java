package com.project.integrator.unisa.integrativeProject_Containerized_systems.repository;

import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.integrator.unisa.integrativeProject_Containerized_systems.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    @EntityGraph(attributePaths = "endereco")
    List<Cliente> findAll();
}
