package models;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
	
	private String nome;
	int cargaHoraria;
	private Curso curso;

	public Disciplina(String nome, int cargaHoraria, Curso curso) {
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.curso = curso;
	}	

	/*
	 * Gets
	 */
	public String getNome() {
        return nome;
    }
	public int getCargaHoraria(){
		return cargaHoraria;
	}
	public Curso getCurso(){
		return curso;
	}

	@Override
	public String toString(){
		return"===Disciplina===\n" + nome + "\n===Carga Horaria===\n" + cargaHoraria + "\n===Cruso===\n" + curso.getNome() + "\n";
	}

}
