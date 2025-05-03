// Ao carregar a página, este script será executado

// Recupera os dados da empresa armazenados no sessionStorage
const empresa = JSON.parse(sessionStorage.getItem("empresa"));

// Verifica se existe uma empresa logada
if (!empresa || !empresa.nome) {
//    Se não houver empresa logada, redireciona para a página de login
    alert("Você precisa estar logado como empresa para acessar esta página.");
    window.location.href = "index.html";
} else {
//    Se houver, exibe o nome da empresa no navbar (ou outro lugar)
    const spanNome = document.getElementById("nomeEmpresa");
    if (spanNome) {
        spanNome.textContent = empresa.nome;
    }
}

// Função para logout (pode ser chamada no botão "Sair")

btnLogout.addEventListener("click", function(){
    
    //redireciona para tela de login
    window.location.href = "index.html"
})