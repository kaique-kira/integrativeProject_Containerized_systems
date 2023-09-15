package com.project.integrator.unisa.integrativeProject_Containerized_systems.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Funcionario extends Pessoa{

    @Column(name = "data_admissao", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataAdmissao;

    @Column(name = "data_demissao")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataDemissao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargo_id_fk", nullable = false)
    private Cargo cargo;
}
