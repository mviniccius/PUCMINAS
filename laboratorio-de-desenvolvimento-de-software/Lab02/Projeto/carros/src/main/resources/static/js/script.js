function listarUsuarios() {
  fetch("http://localhost:8080/users")
    .then(res => res.json())
    .then(usuarios => {
      usuarios.forEach(u => console.log(`Nome: ${u.nome}, Email: ${u.email}`));
    });
}
function listarCarros() {
  fetch("http://localhost:8080/cars")
    .then(res => res.json())
    .then(carros => {
        carros.forEach(c => console.log
        (`Marca: ${c.marca}, Modelo: ${c.modelo}, Ano: ${c.ano}, Placa: ${c.placa}`));
    });
}