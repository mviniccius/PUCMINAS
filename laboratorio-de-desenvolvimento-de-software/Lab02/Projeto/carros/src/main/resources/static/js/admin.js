document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("formCadastro");

  form.addEventListener("submit", (e) => {
    e.preventDefault();

    const nome = document.getElementById("nome").value;
    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;

    const novoUsuario = {
      nome,
      email,
      senha
    };

    fetch("http://localhost:8080/users", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(novoUsuario)
    })
      .then(res => {
        if (!res.ok) {
          throw new Error("Erro ao cadastrar usuário");
        }
        return res.json();
      })
      .then(data => {
        document.getElementById("mensagemCadastro").textContent = "✅ Funcionário cadastrado com sucesso!";
        form.reset();
      })
      .catch(err => {
        document.getElementById("mensagemCadastro").textContent = "❌ Erro ao cadastrar funcionário.";
        console.error(err);
      });
  });
});

document.addEventListener("DOMContentLoaded", () => {
  const btnListarUsuarios = document.getElementById("btnListarUsuarios");
  const usuariosContainer = document.getElementById("usuariosContainer");
  const listaUsuarios = document.getElementById("listaUsuarios");

  btnListarUsuarios.addEventListener("click", () => {
    // Alterna visibilidade
    usuariosContainer.classList.toggle("d-none");

    // Se for exibido, busca os usuários
    if (!usuariosContainer.classList.contains("d-none")) {
      fetch("http://localhost:8080/users")
        .then(res => res.json())
        .then(usuarios => {
          listaUsuarios.innerHTML = "";

          if (usuarios.length === 0) {
            listaUsuarios.innerHTML = "<p>Nenhum usuário encontrado.</p>";
            return;
          }

          usuarios.forEach(user => {
            const item = document.createElement("div");
            item.classList.add("border", "rounded", "p-2", "mb-2", "d-flex", "justify-content-between", "align-items-center");
            item.innerHTML = `
              <div>
              <p><strong>Nome:</strong> ${user.nome}</p>
              <p><strong>Email:</strong> ${user.email}</p>
              </div>
              <button class="btn btn-danger btn-sm" onclick="excluirUsuario('${user.id}')">Excluir</button>
            `;
            listaUsuarios.appendChild(item);
          });
        })
        .catch(err => {
          console.error("Erro ao buscar usuários:", err);
          listaUsuarios.innerHTML = "<p class='text-danger'>Erro ao buscar usuários.</p>";
        });
    }
  });
});

function excluirUsuario(id) {
  if (confirm("Tem certeza que deseja excluir este usuário?")) {
    fetch(`http://localhost:8080/users/${id}`, {
      method: "DELETE"
    })
      .then(res => {
        if (!res.ok) {
          throw new Error("Erro ao excluir usuário");
        }
        alert("Usuário excluído com sucesso!");
        // Atualiza a lista
        document.getElementById("btnListarUsuarios").click(); // Oculta
        document.getElementById("btnListarUsuarios").click(); // Mostra de novo
      })
      .catch(err => {
        console.error(err);
        alert("Erro ao excluir usuário.");
      });
  }
}

document.addEventListener("DOMContentLoaded", () => {
  const btnListarContratos = document.getElementById("btnListarContratos");
  const contratosContainer = document.getElementById("contratosContainer");
  const listaContratos = document.getElementById("listaContratos");

  btnListarContratos.addEventListener("click", () => {
    contratosContainer.classList.toggle("d-none");

    if (!contratosContainer.classList.contains("d-none")) {
      fetch("http://localhost:8080/rent")
        .then(res => res.json())
        .then(contratos => {
          listaContratos.innerHTML = "";

          if (contratos.length === 0) {
            listaContratos.innerHTML = "<p>Nenhum contrato encontrado.</p>";
            return;
          }

          contratos.forEach(contrato => {
            const item = document.createElement("div");
            item.classList.add("border", "rounded", "p-2", "mb-3");

            Promise.all([
              fetch(`http://localhost:8080/users/${contrato.userId}`).then(res => res.json()),
              fetch(`http://localhost:8080/cars/${contrato.carId}`).then(res => res.json())
            ])
            .then(([usuario, carro]) => {
              item.innerHTML = `
                <p><strong>Nome:</strong> ${usuario.nome}</p>
                <p><strong>Carro:</strong> ${carro.marca} ${carro.modelo} (${carro.ano})</p>
                <p><strong>Período:</strong> ${contrato.dataInicio} até ${contrato.dataFim}</p>
                <button class="btn btn-danger btn-sm" onclick="cancelarContrato('${contrato.id}', '${carro.id}')">Cancelar contrato</button>
              `;
              listaContratos.appendChild(item);
            })
            .catch(err => {
              console.error("Erro ao buscar dados relacionados:", err);
              item.innerHTML = `<p class="text-danger">Erro ao carregar dados do contrato</p>`;
              listaContratos.appendChild(item);
            });
          });
        })
        .catch(err => {
          console.error("Erro ao buscar contratos:", err);
          listaContratos.innerHTML = "<p class='text-danger'>Erro ao buscar contratos.</p>";
        });
    }
  });
});

function cancelarContrato(contratoId, carroId) {
  if (confirm("Tem certeza que deseja cancelar este contrato?")) {
    fetch(`http://localhost:8080/rent/${contratoId}`, {
      method: "DELETE"
    })
    .then(res => {
      if (!res.ok) {
        throw new Error("Erro ao excluir contrato");
      }

      // Marcar carro como disponível novamente
      return fetch(`http://localhost:8080/cars/${carroId}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({ disponivel: true }) // só atualiza a disponibilidade
      });
    })
    .then(() => {
      alert("Contrato cancelado e carro liberado com sucesso!");
      document.getElementById("btnListarContratos").click(); // esconde
      document.getElementById("btnListarContratos").click(); // mostra de novo
    })
    .catch(err => {
      console.error(err);
      alert("Erro ao cancelar o contrato.");
    });
  }
}

document.addEventListener("DOMContentLoaded", () => {
  const btnListarCarros = document.getElementById("btnListarCarros");
  const carrosContainer = document.getElementById("carrosContainer");
  const listaCarros = document.getElementById("listaCarros");

  btnListarCarros.addEventListener("click", () => {
    carrosContainer.classList.toggle("d-none");

    if (!carrosContainer.classList.contains("d-none")) {
      fetch("http://localhost:8080/cars")
        .then(res => res.json())
        .then(carros => {
          listaCarros.innerHTML = "";

          if (carros.length === 0) {
            listaCarros.innerHTML = "<p>Nenhum carro cadastrado.</p>";
            return;
          }

          carros.forEach(carro => {
            const item = document.createElement("div");

            // Aplica cor verde ou vermelha no fundo
            item.classList.add("rounded", "p-3", "mb-2", "text-white");
            item.style.backgroundColor = carro.disponivel ? "#28a745" : "#dc3545"; // verde ou vermelho

            item.innerHTML = `
              <div class="d-flex justify-content-between align-items-center">
                <div>
                  <p class="mb-1"><strong>${carro.marca} ${carro.modelo}</strong> (${carro.ano})</p>
                  <p class="mb-0"><strong>Status:</strong> ${carro.disponivel ? "Disponível" : "Indisponível"}</p>
                </div>
                <button class="btn btn-dark btn-sm" onclick="excluirCarro('${carro.id}')">Excluir</button>
              </div>
            `;

            listaCarros.appendChild(item);
          });
        })
        .catch(err => {
          console.error("Erro ao buscar carros:", err);
          listaCarros.innerHTML = "<p class='text-danger'>Erro ao buscar carros.</p>";
        });
    }
  });
});
function excluirCarro(id) {
  if (confirm("Tem certeza que deseja excluir este carro?")) {
    fetch(`http://localhost:8080/cars/${id}`, {
      method: "DELETE"
    })
    .then(res => {
      if (!res.ok) {
        throw new Error("Erro ao excluir carro");
      }
      alert("Carro excluído com sucesso!");
      document.getElementById("btnListarCarros").click(); // Oculta
      document.getElementById("btnListarCarros").click(); // Mostra de novo
    })
    .catch(err => {
      console.error(err);
      alert("Erro ao excluir o carro.");
    });
  }
}
