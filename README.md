# Projeto API de Controle de Produtos

Este projeto consiste em uma API RESTful desenvolvida com Spring Boot para gerenciar um cadastro de produtos. Inclui operações de criação, leitura, atualização e exclusão (CRUD) de produtos, bem como uma interface web básica para interação com o usuário.

# Estrutura do Projeto
Pacotes
com.api.demo.controller: Contém os controladores da API.
com.api.demo.dto: Contém os Data Transfer Objects (DTOs).
com.api.demo.models: Contém as classes de modelo.
com.api.demo.repository: Contém as interfaces de repositório.

# Dependências Principais
Spring Boot
Spring Web
Spring Data JPA
Jakarta Validation
Swagger

# Endpoints da API
Cadastrar Produto
URL: /api/cadastrar-produto
Método: POST

Listar Produto
URL: /api/listar-produto/{codigo_produto}
Método: GET

Deletar Produto
URL: /api/deletar-produto/{codigo_produto}
Método: DELETE

Atualizar Produto
URL: /api/atualizar-produto/{codigo_produto}
Método: PUT

# A interface web foi construída utilizando HTML, CSS, Bootstrap e Funções Java Script.

# Funcionalidades
Menu de navegação.
Formulário para cadastro de produtos.
Termo de aceite para cadastro.
Botões para limpar e enviar o formulário.
Funções de validações e de consumo de api.
