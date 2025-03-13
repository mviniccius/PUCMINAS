package services;

import models.Curso;

import java.util.ArrayList;
import java.util.List;

public class SistemaCursos {

    private List<Curso> cursos;

    public SistemaCursos(){
        this.cursos = new ArrayList<>();
    }

    public boolean cadastrarCurso(String nome, int creditos){
        for(Curso curso : cursos){
            if(curso.getNome().equalsIgnoreCase(nome)){
                return false;
            }
        }
        cursos.add(new Curso(nome, creditos));
        return true;
    }
    
    public List<Curso> listarCursos(){
        return cursos;
    }
}
