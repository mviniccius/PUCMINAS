document.addEventListener("DOMContentLoaded", () => {
    const sairBtn = document.getElementById("botaoSair");
  
    if (sairBtn) {
      sairBtn.addEventListener("click", () => {
        localStorage.clear(); 
        window.location.href = "index.html";
      });
    }
  });
  