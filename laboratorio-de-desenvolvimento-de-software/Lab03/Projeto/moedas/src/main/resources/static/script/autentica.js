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

        if (response.ok){
            const aluno = await response.json();
            
            //Guardar dados no local storage
            sessionStorage.setItem("aluno", JSON.stringify(aluno));

            //redireciona para tela do aluno:
            console.log("Cheguei aqui para redirecionar!!!")
            window.location.href="aluno.html";

        }else {
            const erro = await response.text();
            alert("Erro ao fazer login " + erro);
        }
    } catch (err) {
        alert("Erro na requisição " + err.message);
    }

});