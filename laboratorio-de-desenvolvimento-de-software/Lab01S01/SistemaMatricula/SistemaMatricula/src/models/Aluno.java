package models;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
	
	private String nome;
	private String semestre;
	private List<Disciplina> disciplinasObrigatorias = new ArrayList<>();
	private List<Disciplina> disciplinasOptativas = new ArrayList<>();
	
	
	public Aluno(String login, String senha, String nome, String semestre){
		super(login, senha);
		this.nome = nome;
		this.semestre = semestre;		
	}
	
	public boolean matricular(Disciplina disciplina, boolean obrigatoria) {
		if(obrigatoria) {
			if(disciplinasObrigatorias.size() < 4) {
				disciplinasObrigatorias.add(disciplina);
				return true;
			}else {
				System.out.println("Limite 4 disciplinas atingido!");
				return false;
			}
		}else {
			if(disciplinasOptativas.size() < 2) {
				disciplinasOptativas.add(disciplina);
				return true;
			}else {
				System.out.println("Limite de 2 disciplinas atingido!");
				return false;
			}
		}
		
	}
	
	public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }
	
}
