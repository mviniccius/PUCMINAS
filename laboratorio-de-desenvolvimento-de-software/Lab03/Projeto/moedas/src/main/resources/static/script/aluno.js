//recupera os dados do local storage
const aluno = JSON.parse(sessionStorage.getItem("aluno"));

//recupera o dado de saldo do aluno
document.getElementById("saldoMoedas").textContent = aluno.saldoMoedas;


//verifica se tem aluno logado
if (aluno && aluno.nome) {
    document.getElementById("nomeAluno").textContent = aluno.nome;
} else {
    //se não tiver logado redireciona para login
    alert("Voce precisa logar!");
    window.location.href = "index.html";
}

//logout
const btnLogout = document.getElementById("btnLogout");

//Evento de click no botao
btnLogout.addEventListener("click", function () {
    //Remove os dados do aluno do local storage
    sessionStorage.removeItem("aluno");

    //Redireciona para tela de login
    window.location.href = "index.html"
});

//troca entre Home e Cupons
function mostrarHome() {
    //exibe a seção Home, default
    document.getElementById("areaHome").style.display = "block";
    //exbie a seção Cupons
    document.getElementById("areaCupons").style.display = "none";
}
function mostrarCupons() {
    //esconde seção Home
    document.getElementById("areaHome").style.display = "none";
    //exibe Cupons
    document.getElementById("areaCupons").style.display = "block";

    // Chama a função de carregar os cupons depois que a área está visível
    carregarCuponsDisponiveis();

    // (Opcional) Garante que o usuário veja os cupons mesmo que estejam mais abaixo na tela
    areaCupons.scrollIntoView({ behavior: "smooth" });
}

//carregar cupons disponiveis
async function carregarCuponsDisponiveis() {
    try {
        //chama o backend para buscar cupons disponiveis > 0
        const resposta = await fetch("/vantagens/disponiveis");
        const cupons = await resposta.json();

        //seleciona a div onde os cards serao inseridos
        const container = document.getElementById("listaCupons");
        container.innerHTML = "";//limpa o conteudo atual

        //para cada cupom, cria um card com classes Bootstrap
        cupons.forEach(cupom => {
            const card = document.createElement("div");
            card.className = "card shadow p-3 bg-light rounded";
            card.style.width = "18rem";
            card.style.height = "100%";

            card.innerHTML = `
                <img src="${cupom.imagemUrl}" class="card-img-top" alt="${cupom.nome}" style="height: 180px; object-fit: cover;">
                <div class="card-body d-flex flex-column justify-content-between">
                    <div>
                    <h5 class="card-title">${cupom.nome}</h5>
                    <p class="card-text">${cupom.descricao}</p>
                    <p><strong>Valor:</strong> ${cupom.custoMoedas} moedas</p>
                    <p><strong>Disponível:</strong> ${cupom.quantidadeCupm}</p>
                    </div>
                    <button class="btn btn-success mt-2" onclick="comprarCupom('${cupom.id}')">Comprar</button>
                </div>
            `;

            container.appendChild(card);
        });
    } catch (erro) {
        console.error("Erro ao carregar cupons: ", erro);
    }
}

// Função chamada ao clicar em "Comprar"
async function comprarCupom(idCupom) {
    try {
        // Envia requisição PUT para o backend
        const resposta = await fetch(`/vantagens/${idCupom}/comprar`, {
            method: "PUT"
        });

        if (resposta.ok) {
            alert("Cupom comprado com sucesso!");

            // Atualiza a lista de cupons disponíveis
            carregarCuponsDisponiveis();

            // Atualizar saldo do aluno, caso você queira no futuro
        } else {
            const erro = await resposta.text();
            alert("Erro ao comprar cupom: " + erro);
        }

    } catch (erro) {
        console.error("Erro na compra:", erro);
        alert("Erro ao comprar cupom. Tente novamente.");
    }
}
