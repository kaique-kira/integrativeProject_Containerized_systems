package com.project.integrator.unisa.integrativeProject_Containerized_systems.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa {

    @Column(nullable = false)
    private Boolean Ativo;
    
}
