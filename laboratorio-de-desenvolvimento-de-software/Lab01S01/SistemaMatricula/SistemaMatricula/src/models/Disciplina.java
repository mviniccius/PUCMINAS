package models;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
	
	private String nome;
	private int maxAlunos = 60;
	private int minAlunos = 3;
	private List<Aluno> alunosMatriculados = new ArrayList<>();
	
	public Disciplina(String nome) {
		this.nome = nome;
	}
	
	public boolean matricularAluno(Aluno aluno) {
		if(alunosMatriculados.size() < maxAlunos) {
			alunosMatriculados.add(aluno);
			return true;
		}else {
			System.out.println("Turma cheia!");
			return false;
		}		
	}
	public void verificarAtivacao() {
		if(alunosMatriculados.size() < minAlunos) {
			System.out.println("Disciplina " + nome + " Cancelado por falta de alunos!");
		}else {
			System.out.println("Disciplina " + nome + " Terá no proximo semestre!");
		}
	}
	public String getNome() {
        return nome;
    }
}
