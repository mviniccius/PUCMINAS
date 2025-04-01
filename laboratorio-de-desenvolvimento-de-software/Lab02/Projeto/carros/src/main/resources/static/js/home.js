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
        radio.innerHTML=`
        <input type="radio" name="carroSelecionado" value="${carro.id}" required>
        <label>${carro.marca} ${carro.modelo} - ${carro.ano}</label>`;
        container.appendChild(radio);
      });
    })
    .catch(err =>{
      console.error("Erro ao buscar", err);
    })
}
  

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
