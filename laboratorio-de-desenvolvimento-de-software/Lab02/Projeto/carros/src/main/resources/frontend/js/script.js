function listarUsuarios() {
  fetch("http://localhost:8080/users")
    .then(res => res.json())
    .then(usuarios => {
      usuarios.forEach(u => console.log(`Nome: ${u.nome}, Email: ${u.email}`));
    });
}

  function listarUsuarios() {
    fetch("http://localhost:8080/cars")
      .then(res => res.json())
      .then(usuarios => {
        document.getElementById("saida").textContent = JSON.stringify(usuarios, null, 2);
      });
  }
 aaaaaa