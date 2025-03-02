package services;

import models.*;

import java.util.ArrayList;
import java.util.List;


public class SistemaAutenticacao {
    private List<Aluno> alunos;
    private List<Professor> professores;
    private List<Secretaria> secretarias;


    public SistemaAutenticacao(){
        this.alunos = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.secretarias = new ArrayList<>();

        mockUsuarios();
    }
    //Mock
    private void mockUsuarios() {
        alunos.add(new Aluno("João Silva", "j1", "1234", "20231001", "Engenharia", 4));
        professores.add(new Professor("Carlos Andrade", "carlos@hotmail", "senha123", "Banco de Dados"));
        secretarias.add(new Secretaria("Maria Souza", "maria@hotmail", "admin"));
    }

    public Usuario autenticarAluno(String matricula, String senha){
        for(Aluno aluno: alunos){
            if(aluno.getMatricula().equals(matricula) && aluno.autenticar(senha)){
                return aluno;
            }
        }
        return null;
    }

    public Usuario autenticarProfessor(String email, String senha){
        for(Professor professor: professores){
            if(professor.getEmail().equals(email) && professor.autenticar(senha)){
                return professor;
            }
        }
        return null;
    }

    public Usuario autenticarSecretaria(String email, String senha){
        for(Secretaria secretaria : secretarias){
            if(secretaria.getEmail().equals(email) && secretaria.autenticar(senha)){
                return secretaria;
            }
        }
        return null;
    }
}
