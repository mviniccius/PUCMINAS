document.addEventListener("DOMContentLoaded", () => {
  const btnMostrarCadastro = document.getElementById("btnMostrarCadastro");
  const formContainer = document.getElementById("formContainer");

  btnMostrarCadastro.addEventListener("click", () => {
    formContainer.classList.toggle("d-none");

    // alterna o texto do botão
    if (formContainer.classList.contains("d-none")) {
      btnMostrarCadastro.textContent = "Cadastrar novo usuário";
    } else {
      btnMostrarCadastro.textContent = "Esconder formulário";
    }
  });
});
