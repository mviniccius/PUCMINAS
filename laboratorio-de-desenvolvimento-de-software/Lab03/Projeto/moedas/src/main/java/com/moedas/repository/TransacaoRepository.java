package com.moedas.repository;

import com.moedas.model.Transacao;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface TransacaoRepository extends MongoRepository<Transacao, String> {
    // Lista transações de um aluno, mais recentes primeiro
    List<Transacao> findByAlunoIdOrderByDataDesc(String alunoId);

    // Lista transações feitas por um professor (envios), mais recentes primeiro
    List<Transacao> findByProfessorIdOrderByDataDesc(String professorId);
}
