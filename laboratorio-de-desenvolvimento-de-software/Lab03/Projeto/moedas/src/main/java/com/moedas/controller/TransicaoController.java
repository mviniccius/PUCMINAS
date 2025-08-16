package com.moedas.controller;

import com.moedas.model.Professor;
import com.moedas.model.Transacao;
import com.moedas.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransicaoController {

    @Autowired
    private TransacaoService transacaoService;

    //listar todas as transacoes
    @GetMapping
    public List<Transacao> listarTransacoes(){
        return transacaoService.listarTodasTransacoes();
    }


    //lista somente as transacoes de recebimento do aluno
    @GetMapping("/aluno/{id}")
    public ResponseEntity<List<Transacao>> listarPorAluno(@PathVariable String id){
        List<Transacao> transacoes = transacaoService.listarRecebimentosDoAluno(id);
        return ResponseEntity.ok(transacoes);
    }


    //lista todas as transacoes de um aluno
    @GetMapping("/aluno/{id}/recebidas")
    public ResponseEntity<List<Transacao>> listarRecebidas(@PathVariable String id){
        List<Transacao> recebidas = transacaoService.listarRecebimentosDoAluno(id);
        return ResponseEntity.ok(recebidas);
    }

    @GetMapping("/professor/{id}")
    public ResponseEntity<List<Transacao>> listarPorProfessor(@PathVariable String id){
        List<Transacao> transacoes = transacaoService.listarPorProfessor(id);
        return ResponseEntity.ok(transacoes);
    }

}
