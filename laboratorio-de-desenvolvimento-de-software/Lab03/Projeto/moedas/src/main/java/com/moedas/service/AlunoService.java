package com.moedas.service;


import com.moedas.model.Aluno;
import com.moedas.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listarTodosAlunos(){
        return alunoRepository.findAll();
    }

    public Aluno salvar(Aluno aluno){
        aluno.setSaldoMoedas(0);
        aluno.setTipo("aluno");
        return alunoRepository.save(aluno);
    }
}
