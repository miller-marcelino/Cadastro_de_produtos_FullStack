// Inicio do trecho responsal por validar o fomulario de cadastro

//Converte o campo nome para maisculo
function converteNomeParaMaiusculo() {
   document.getElementById('nome').value = document.getElementById('nome').value.toUpperCase();
}

//Converte o campo cor para maisculo
function converteCorParaMaiusculo() {
    document.getElementById('cor').value = document.getElementById('cor').value.toUpperCase();
}






// Função para cadastrar Produtos
function cadastrarProdutos() {
    // Criando um objeto com os dados do formulário
    let obj = {
        cor: document.getElementById("cor").value, // Obtém o valor do campo cor
        nome: document.getElementById("nome").value, // Obtém o valor do campo de nome
        };

    // Criando solicitação XMLHttpRequest
    const xhttp = new XMLHttpRequest();

    // Definindo o que fazer quando a solicitação é concluída
    xhttp.onload = function () {
        // Exibindo um alerta com a resposta da API
        alert(this.responseText);
        
        
    };

    // Configurando a solicitação POST para a URL da API
    xhttp.open("POST", "http://localhost:8081/api/cadastrar-produto");

    // Configurando os cabeçalhos da solicitação
    xhttp.setRequestHeader("Accept", "application/json");
    xhttp.setRequestHeader("Content-Type", "application/json");

    // Enviando a solicitação com os dados do formulário convertidos para JSON
    xhttp.send(JSON.stringify(obj));
}


