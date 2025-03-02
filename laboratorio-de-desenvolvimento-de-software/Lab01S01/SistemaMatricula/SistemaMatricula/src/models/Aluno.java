package models;


public class Aluno extends Usuario {
	
	private String matricula;
	private String curso;
	private int periodo;
	
	
	public Aluno(String nome,String email, String senha, String matricula,String curso, int periodo){
		super(nome, email, senha);		
		this.matricula = matricula;
		this.curso = curso;
		this.periodo = periodo;		
	}
	public String getMatricula(){
		return matricula;
	}

	@Override
	public String toString(){
		return "===Aluno===\n" + nome + "\n===Marticula===\n" + matricula + "\n===Curso===\n" + curso + "\n===Periodo===\n" + periodo;
	}
	
	
}
