package com.api.demo.dto;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProdutoDto {

    @NotBlank(message = "O campo nome deve ser preenchido")
    @Size(min = 2, max = 50, message = "O campo nome deve ter no mínimo 2 caracter e no máximo 50")
    private String nome;

    @NotBlank(message = "O campo de ser preenchido")
    @Size(min = 2, max = 30, message = "O campo cor deve ter no mínimo 2 e no máximo 30 caracter")
    private String cor;

}
