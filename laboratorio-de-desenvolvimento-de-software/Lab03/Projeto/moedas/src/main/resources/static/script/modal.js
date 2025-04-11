function mostrarCampos(){
    const tipo = document.getElementById('tipoUsuario').value;
    const formCampos = document.getElementById('formCampos');
    const camposAluno = document.getElementById('camposAluno');
    const camposEmpresa = document.getElementById('camposEmpresa');

    if(tipo){
        formCampos.style.display = 'block';
        camposAluno.style.display = tipo === 'aluno' ? 'block' : 'none';
        camposEmpresa.style.display = tipo === 'empresa' ? 'block' : 'none';
    }else{
        formCampos.style.display = 'none';
        camposAluno.style.display = 'none';
        camposEmpresa.style.display = 'none';
    }
}