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
@MappedSuperclass
public abstract class Pessoa extends Entidade{

    @Column(nullable = false, length = 80)
    private String nome;

    @Column(nullable = false, length = 14, unique = true)
    private String cpf;

    @Column(nullable = false, length = 15)
    private String email;

    @Column(nullable = false, length = 15)
    private String telefone;

    @Column(name = "data_nascimento", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataNascimento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id_fk", nullable = false)
    private Endereco endereco;
}
