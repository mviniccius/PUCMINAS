document.addEventListener("DOMContentLoaded", function(){

    const form = document.getElementById("loginForm");

    form.addEventListener("submit", function(e){
        e.preventDefault();

        const email = document.getElementById("email").value;
        const senha = document.getElementById("senha").value;

        fetch("http://localhost:8080/users/login", {
            method: "POST",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify({email, senha})
        
        }).then(res=>{
            if(!res.ok){
                throw new Error("ERROU");
            }
            return res.json();
        
        }).then(usuario => {
            console.log("Bem vindo: ", usuario);

            localStorage.setItem("userId", usuario.id);
            localStorage.setItem("nome", usuario.nome);

            if(usuario.email === "admin@admin.com"){
                window.location.href = "admin.html"
            }else{
                window.location.href = "home.html";
            }
        
        }).catch(err => {
            alert("ERROU");
            console.error("ERRO ", err);
        });
    
    });

});
