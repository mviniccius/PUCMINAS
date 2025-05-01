//recupera os dados do local storage
const aluno = JSON.parse(sessionStorage.getItem("aluno"));

//verifica se tem aluno logado
if(aluno && aluno.nome){
    document.getElementById("nomeAluno").textContent = aluno.nome;
} else{
    //se não tiver logado redireciona para login
    alert("Voce precisa logar!");
    window.location.href = "index.html";
}

//logout
const btnLogout = document.getElementById("btnLogout");

//Evento de click no botao
btnLogout.addEventListener("click", function(){
    //Remove os dados do aluno do local storage
    sessionStorage.removeItem("aluno");

    //Redireciona para tela de login
    window.location.href = "index.html"
});

//troca entre Home e Cupons
function mostrarHome(){
    //exibe a seção Home, default
    document.getElementById("areaHome").style.display = "block";
    //exbie a seção Cupons
    document.getElementById("areaCupons").style.display = "none";
}
function mostrarCupons(){
    //esconde seção Home
    document.getElementById("areaHome").style.display = "none";
    //exibe Cupons
    document.getElementById("areaCupons").style.display = "block";
}