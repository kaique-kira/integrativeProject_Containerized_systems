package com.project.integrator.unisa.integrativeProject_Containerized_systems.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cargo extends Entidade{

    @Column(nullable = false, length = 40, unique = true)
    private String nome;

}
