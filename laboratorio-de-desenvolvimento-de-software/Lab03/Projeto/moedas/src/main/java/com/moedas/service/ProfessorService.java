package com.moedas.service;

import com.moedas.model.Professor;
import com.moedas.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor>listarTodosProfessores(){
        return professorRepository.findAll();
    }

    public Professor salvar(Professor professor){
        professor.setSaldoMoedas(1000);
        professor.setTipo("professor");
        return professorRepository.save(professor);
    }

}
