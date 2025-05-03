// Espera o carregamento completo da página
document.addEventListener("DOMContentLoaded", () => {
    carregarCupons();
  });
  
  // Busca os cupons disponíveis no backend
  async function carregarCupons() {
    try {
      const resposta = await fetch("/vantagens/disponiveis");
      const cupons = await resposta.json();
  
      const container = document.getElementById("listaCupons");
      container.innerHTML = ""; // limpa a área antes de renderizar
  
      cupons.forEach(cupom => {
        const card = document.createElement("div");
        card.className = "card";
        card.style.width = "18rem";
  
        card.innerHTML = `
          <img src="${cupom.imagemUrl}" class="card-img-top" alt="${cupom.nome}" style="height: 180px; object-fit: cover;">
          <div class="card-body">
            <h5 class="card-title">${cupom.nome}</h5>
            <p class="card-text">${cupom.descricao}</p>
            <p><strong>Valor:</strong> ${cupom.custoMoedas} moedas</p>
            <p><strong>Disponível:</strong> ${cupom.quantidadeCupm}</p>
          </div>
        `;
  
        container.appendChild(card);
      });
  
    } catch (erro) {
      console.error("Erro ao carregar cupons:", erro);
    }
  }
  