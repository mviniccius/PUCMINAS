package models;

public class Professor extends Usuario{
	
	private String nome;
	private String titulacao;
	
	public Professor(String login, String senha, String nome, String titulacao) {
		super(login, senha);
		this.nome = nome;
		this.titulacao = titulacao;
	}
	
	public void visualizarAlunosMatriculdados(Disciplina disciplina) {
		System.out.println(disciplina.getNome());
	}
}
