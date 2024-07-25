package com.api.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codigo", nullable = false)
    private Long codigo;

    @Column(name = "Nome", columnDefinition = "TEXT", nullable = false)
    private String nome;

    @Column(name = "Cor", columnDefinition = "TEXT", nullable = false)
    private String cor;

}
