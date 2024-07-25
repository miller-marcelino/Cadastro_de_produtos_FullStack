package com.api.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.demo.models.Produtos;

public interface RepositoryProdutos extends JpaRepository<Produtos, Long> {

}
