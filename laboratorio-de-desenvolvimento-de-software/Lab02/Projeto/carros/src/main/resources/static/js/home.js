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
  

function alugarCarro(carId) {
const userId = localStorage.getItem("userId");
const dataInicio = document.getElementById(`inicio-${carId}`).value;
const dataFim = document.getElementById(`fim-${carId}`).value;

const aluguel = {
    userId: userId,
    carId: carId,
    dataInicio: dataInicio,
    dataFim: dataFim
};

fetch("http://localhost:8080/rents", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(aluguel)
})
.then(res => {
    if (!res.ok) throw new Error("Erro ao alugar o carro");
    return res.json();
})
.then(data => {
    alert("✅ Aluguel realizado com sucesso!");
    console.log(data);
})
.catch(err => {
    alert("❌ Erro ao realizar o aluguel");
    console.error(err);
});
}
