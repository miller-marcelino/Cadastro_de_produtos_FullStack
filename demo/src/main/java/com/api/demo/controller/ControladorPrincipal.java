package com.api.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import com.api.demo.dto.ProdutoDto;
import com.api.demo.models.Produtos;
import com.api.demo.repository.RepositoryProdutos;

@RestController

@RequestMapping("/api")

public class ControladorPrincipal {
    @Autowired
    private RepositoryProdutos repositoryProdutos;

    @CrossOrigin(origins = "*")

    /* Salvar produtos */
    @PostMapping("/cadastrar-produto")

    private ResponseEntity<?> cadastrarprodutos(@RequestBody @Valid ProdutoDto produtodto,
            BindingResult bindingResult) {
        try {
            Produtos novoProduto = new Produtos();

            novoProduto.setNome(produtodto.getNome());
            novoProduto.setCor(produtodto.getCor());
System.out.println(produtodto.getNome());
System.out.println(produtodto.getCor());
            novoProduto = repositoryProdutos.save(novoProduto);
            return new ResponseEntity<>("Produto Cadastrado com sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao cadastrar produto" + e.getMessage());
        }
    }

    /* Listar Produto */
    @GetMapping(value = "listar-produto/{codigo_produto}")
    public ResponseEntity<Produtos> listarProduto(@PathVariable Long codigo_produto) {
        Optional<Produtos> produto = repositoryProdutos.findById(codigo_produto);

        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // Deletar Produtos

    @DeleteMapping("deletar-produto/{codigo_produto}")
    public ResponseEntity<Long> deletarProdutos(@PathVariable Long codigo_produto) {
        boolean existeProduto = repositoryProdutos.existsById(codigo_produto);
        if (existeProduto) {
            repositoryProdutos.deleteById(codigo_produto);
            return new ResponseEntity<>(codigo_produto, HttpStatus.OK);
        }
        return new ResponseEntity<>(codigo_produto, HttpStatus.NO_CONTENT);
    }

    // Atualizar Produtos
    @PutMapping("atualizar-produto/{codigo_produto}")
    public ResponseEntity<Produtos> atualizarProdutos(@PathVariable Long codigo_produto,
            @RequestBody ProdutoDto produtoDto) {

        Optional<Produtos> existingProdutos = repositoryProdutos.findById(codigo_produto);

        if (existingProdutos.isPresent()) {

            Produtos produtosExistente = existingProdutos.get();
            produtosExistente.setNome(produtoDto.getNome());
            produtosExistente.setCor(produtoDto.getCor());

            Produtos produtoatualizado = repositoryProdutos.save(produtosExistente);

            return ResponseEntity.ok(produtoatualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
