package services;

import models.Curso;
import models.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class SistemaDisciplinas {
    private List<Disciplina> disciplinas;

    public SistemaDisciplinas(List<Curso> cursos) {
        this.disciplinas = new ArrayList<>();
        mockDisciplinas(cursos);
    }

    // 📌 Criar disciplinas mockadas associadas aos cursos
    private void mockDisciplinas(List<Curso> cursos) {
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso disponível para associar disciplinas.");
            return;
        }

        for (Curso curso : cursos) {
            disciplinas.add(new Disciplina("Algoritmos e Estruturas de Dados", 60, curso));
            disciplinas.add(new Disciplina("Banco de Dados", 50, curso));
            disciplinas.add(new Disciplina("Programação Orientada a Objetos", 70, curso));
        }
    }

    public List<Disciplina> listarDisciplinas() {
        return disciplinas;
    }
}
