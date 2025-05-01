document.getElementById('formCadastro').addEventListener('submit', async function (e) {
    e.preventDefault();

    const tipo = document.getElementById('tipoUsuario').value;
    const nome = document.getElementById('nome').value;
    const email = document.getElementById('emailModal').value;
    const senha = document.getElementById('senhaModal').value;

    let dados = { nome, email, senha };

    if (tipo === 'aluno') {
        dados.cpf = document.getElementById('cpf').value;
        dados.rg = document.getElementById('rg').value;
        dados.endreco = document.getElementById('endereco').value;
        dados.instituicao = document.getElementById('instituicao').value;
        dados.curso = document.getElementById('curso').value;
    } else if (tipo === 'empresa') {
        dados.cnpj = document.getElementById('cnpj').value;
    } else {
        alert("Selecione um tipo de usuário.");
        return;
    }

    const url = tipo === 'aluno' ? '/alunos' : '/empresa';

    try {
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dados)
        });

        if (response.ok) {
            alert(`${tipo.charAt(0).toUpperCase() + tipo.slice(1)} cadastrado com sucesso!`);
            document.getElementById('formCadastro').reset();
            mostrarCampos();
            const modal = bootstrap.Modal.getInstance(document.getElementById('modalCadastro'));
            modal.hide();
        } else {
            const errorText = await response.text();
            alert(`Erro ao cadastrar: ${errorText}`);
        }
    } catch (error) {
        alert('Erro ao enviar os dados: ' + error.message);
    }
});
