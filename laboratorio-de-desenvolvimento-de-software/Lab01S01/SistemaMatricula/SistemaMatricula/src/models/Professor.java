package models;

public class Professor extends Usuario{
	
	private String disciplina;


	public Professor (String nome, String email, String senha, String disciplina){
		super(nome, email, senha);
		this.disciplina = disciplina;
	}



	@Override
	public String toString(){
		return "===Professor===\n" + nome + "\n===Disciplina===\n" + disciplina + "\n\n";
	}
}
