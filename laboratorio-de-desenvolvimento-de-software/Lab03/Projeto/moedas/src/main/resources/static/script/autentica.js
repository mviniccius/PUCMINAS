document.querySelector("form").addEventListener("submit", async function(e){
    e.preventDefault();

    //capturar dados do formulario
    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;

    //Requisicao
    const loginDTO = {
        email: email,
        senha: senha
    };

    try{
        const response = await fetch("/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(loginDTO)
        });

        if (response.ok) {
            const usuario = await response.json(); // Lê o corpo da resposta como JSON

            // Verifica o tipo de usuário retornado pelo backend
            if (usuario.tipo === "aluno") {
                // Guarda os dados do aluno no sessionStorage
                sessionStorage.setItem("aluno", JSON.stringify(usuario));

                // Redireciona para a tela do aluno
                window.location.href = "aluno.html";

            } else if (usuario.tipo === "empresa") {
                // Guarda os dados da empresa no sessionStorage
                sessionStorage.setItem("empresa", JSON.stringify(usuario));

                // Redireciona para a tela da empresa
                window.location.href = "empresa.html";

            } else {
                alert("Tipo de usuário desconhecido.");
            }

        } else {
            // Se a resposta for erro (ex: 401), mostra o texto de erro retornado
            const erro = await response.text();
            alert("Erro ao fazer login: " + erro);
        }

    } catch (err) {
        // Em caso de erro de rede ou falha na requisição
        alert("Erro na requisição: " + err.message);
    }
});