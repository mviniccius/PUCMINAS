package services;

import models.Aluno;
import models.Disciplina;

public class SistemaMatricula {
	
	public void matriculaAlunoEmDisciplina(Aluno aluno, Disciplina disciplina) {
		if(disciplina.matricularAluno(aluno)) {
			System.out.println(aluno + " matricula na disciplina " + disciplina.getNome());
		}
	}
	
}
