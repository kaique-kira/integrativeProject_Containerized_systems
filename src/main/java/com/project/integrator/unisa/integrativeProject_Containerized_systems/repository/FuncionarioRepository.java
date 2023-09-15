package com.project.integrator.unisa.integrativeProject_Containerized_systems.repository;


import com.project.integrator.unisa.integrativeProject_Containerized_systems.entities.Funcionario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @EntityGraph(attributePaths = { "endereco", "cargo"})
    List<Funcionario> findAll();

    @Query("select f from Funcionario f where f.cargo.nome = :cargoNome")
    List<Funcionario> buscaPorCargo(String cargoNome);

    @Query("select f from Funcionario f where f.cargo.nome <> :cargoNome")
    List<Funcionario> buscaPorCargoExceto(String cargoNome);

    List<Funcionario> findByCargoNome(String cargoNome);

    List<Funcionario> findByCargoNomeNot(String cargoNome);
}
