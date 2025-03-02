package models;

public class Curso {
	
	private String nome;
	private int quantidadeSemestres;
	
	public Curso(String nome, int quantidadeSemestres) {
		this.nome = nome;
		this.quantidadeSemestres = quantidadeSemestres;
	}

	public String getNome(){
		return nome;
	}
}
