package com.moedas.service;

import com.moedas.model.Aluno;
import com.moedas.model.Professor;
import com.moedas.model.Transacao;
import com.moedas.repository.AlunoRepository;
import com.moedas.repository.ProfessorRepository;
import com.moedas.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.*;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    //salvar transacao enviada para o  aluno

    public void registrarEnvio(Professor professor, Aluno aluno, int valor, String descricao){
    //cria transacao de envio
        Transacao envio = new Transacao();
        envio.setTipo("envio");
        envio.setValor(valor);
        envio.setDescricao(descricao);
        envio.setData(LocalDate.now());
        envio.setProfessor(professor);
        envio.setAluno(aluno);
        transacaoRepository.save(envio);

    //cria transacao de recebimento para o aluno
        Transacao recebimento = new Transacao();
        recebimento.setTipo("recebimento");
        recebimento.setValor(valor);
        recebimento.setDescricao(descricao);
        recebimento.setData(LocalDate.now());
        recebimento.setProfessor(professor);
        recebimento.setAluno(aluno);
        transacaoRepository.save(recebimento);

    }
}
