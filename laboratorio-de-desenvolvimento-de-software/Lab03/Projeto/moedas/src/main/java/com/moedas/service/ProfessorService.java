package com.moedas.service;

import java.util.Optional;

import com.moedas.model.Aluno;
import com.moedas.model.Professor;
import com.moedas.repository.AlunoRepository;
import com.moedas.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TransacaoService transacaoService;


    public List<Professor>listarTodosProfessores(){
        return professorRepository.findAll();
    }

    public Professor salvar(Professor professor){
        professor.setSaldoMoedas(1000);
        professor.setTipo("professor");
        return professorRepository.save(professor);
    }


    public void enviarMoedas(String idProfessor, String idAluno, int valor, String descricao){
        Professor professor = professorRepository.findById(idProfessor).orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow(() -> new RuntimeException("Aluno nao encontrado"));

        //verifica se professor tem saldo suficiente
        if(professor.getSaldoMoedas() < valor){
            throw new RuntimeException("Saldo insuficiente");
        }

        //atualiza saldos;
        professor.setSaldoMoedas(professor.getSaldoMoedas() - valor);
        aluno.setSaldoMoedas(aluno.getSaldoMoedas() + valor);

        professorRepository.save(professor);
        alunoRepository.save(aluno);

        transacaoService.registrarEnvio(professor, aluno, valor, descricao);
    }

}
