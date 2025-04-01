document.addEventListener("DOMContentLoaded", () => {
  const userId = localStorage.getItem("userId");
  const nome = localStorage.getItem("nome");

  if (!userId || !nome) {
    alert("Você precisa estar logado para acessar esta página.");
    window.location.href = "index.html";
  }else {
    const saudacao = document.getElementById("nome");
    if (saudacao) {
      saudacao.textContent = `Seja bem-vindo, ${nome}`;
    }
  }
});