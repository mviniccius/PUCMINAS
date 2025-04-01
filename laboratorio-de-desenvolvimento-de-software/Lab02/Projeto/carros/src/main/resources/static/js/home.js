function listarCarros() {
    fetch("http://localhost:8080/cars")
      .then(res => res.json())
      .then(carros => {
        const div = document.getElementById("listarCarros");
        div.innerHTML = "";
  
        carros.forEach(carro => {
          const item = document.createElement("div");
          item.innerHTML = `
            <p><strong>${carro.marca} ${carro.modelo}</strong> - ${carro.ano}</p>
            <hr>
          `;
          div.appendChild(item);
        });
      });
  }
        
function listarCarrosDisponiveis(){
  fetch("http://localhost:8080/cars/disponiveis")
    .then(res => res.json())
    .then(carros => {
      const container = document.getElementById("carrosDisponiveis");
      container.innerHTML = "";

      if(carros.length ===0){
        container.innerHTML = "<p>Nenhum carro disponivel.<p>";
        return
      }

      carros.forEach(carro =>{
        const radio = document.createElement("div");
        radio.classList.add("form-check")
        radio.innerHTML=`
        <input type="radio" class="form-check-input" name="carroSelecionado" value="${carro.id}" required>
        <label class="form-check-label">${carro.marca} ${carro.modelo} - ${carro.ano}</label>`;
        container.appendChild(radio);

        radio.querySelector("input").addEventListener("change", verificarCarroSelecionado);
      });
    })
    .catch(err =>{
      console.error("Erro ao buscar", err);
    })
    verificarCarroSelecionado();
}
  
function verificarCarroSelecionado() {
  const reservarBtn = document.getElementById("reservarBtn");
  const radios = document.querySelectorAll('input[name="carroSelecionado"]');
  let carroSelecionado = false;

  radios.forEach(radio => {
      if (radio.checked) {
          carroSelecionado = true;
      }
  });

  reservarBtn.disabled = !carroSelecionado; 
}


window.onload = verificarCarroSelecionado;

function reservarCarro() {
  const userId = localStorage.getItem("userId");
  const carroSelecionado = document.querySelector("input[name='carroSelecionado']:checked");
  const dataInicio = document.getElementById("dataInicio").value;
  const dataFim = document.getElementById("dataFim").value;

  if (!carroSelecionado || !dataInicio || !dataFim) {
    alert("Preencha todos os campos antes de reservar.");
    return;
  }

  const aluguel = {
    userId: userId,
    carId: carroSelecionado.value,
    dataInicio: dataInicio,
    dataFim: dataFim
  };

  fetch("http://localhost:8080/rent", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(aluguel)
  })
    .then(res => {
      if (!res.ok) throw new Error("Erro ao reservar");
      return res.json();
    })
    .then(() => {
      alert("✅ Carro reservado com sucesso!");
      listarCarrosDisponiveis(); // Atualiza a lista para esconder o carro alugado
    })
    .catch(err => {
      console.error("Erro ao reservar:", err);
      alert("❌ Falha ao reservar o carro.");
    });
}

function listarContratos() {
  const userId = localStorage.getItem("userId");

  fetch(`http://localhost:8080/rent/user/${userId}`)
    .then(res => res.json())
    .then(contratos => {
      const div = document.getElementById("meusContratos");
      div.innerHTML = "<h4>Meus Aluguéis:</h4>";

      if (contratos.length === 0) {
        div.innerHTML += "<p>Você ainda não fez nenhum aluguel.</p>";
        return;
      }

      contratos.forEach(c => {
        // Buscar o carro pelo ID
        fetch(`http://localhost:8080/cars/${c.carId}`)
          .then(res => res.json())
          .then(carro => {
            const item = document.createElement("div");
            item.classList.add("border", "rounded", "p-2", "mb-2");

            item.innerHTML = `
              <p><strong>Carro:</strong> ${carro.marca} ${carro.modelo} (${carro.ano})</p>
              <p><strong>Início:</strong> ${c.dataInicio}</p>
              <p><strong>Fim:</strong> ${c.dataFim}</p>
            `;
            div.appendChild(item);
          })
          .catch(err => {
            console.error("Erro ao buscar carro:", err);
          });
      });
    })
    .catch(err => {
      console.error("Erro ao buscar contratos:", err);
      alert("Erro ao carregar seus aluguéis.");
    });
}
