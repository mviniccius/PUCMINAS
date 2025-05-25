package com.moedas.service;


import com.moedas.model.Aluno;
import com.moedas.model.Vantagem;
import com.moedas.repository.AlunoRepository;
import com.moedas.repository.VantagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VantagemService {

    @Autowired
    private VantagemRepository vantagemRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TransacaoService transacaoService;



    //lista todas as vantagens com quantidade maior que 0
    public List<Vantagem> listarDisponiveis(){
        return vantagemRepository.findAll()
                .stream()
                .filter(v -> v.getQuantidadeCupm() >0)
                .collect(Collectors.toList());
    }

    public Vantagem comprarCupom(String idVantagem, String idAluno){
        //buscar cupom pelo ID
        Vantagem cupom = vantagemRepository.findById(idVantagem)
                .orElseThrow(() -> new RuntimeException("cupom nao encontrado"));

        //verifica se o cupom existe
        if (cupom == null){
            throw new RuntimeException("Cupom inexistente");
        }

        //verifica se a quantidade de cupom esta disponivel
        if(cupom.getQuantidadeCupm() <= 0){
            throw new RuntimeException("Cupom esgotado");
        }

        //buscar aluno
        Aluno aluno = alunoRepository.findById(idAluno)
                .orElseThrow(() -> new RuntimeException("Aluno nao encontrado"));

        //verificar se saldo dar para comprar cupom
        if (aluno.getSaldoMoedas() < cupom.getCustoMoedas()){
            throw new RuntimeException("saldo insuficiente");
        }

        //Desconta o valor do cupom do saldo do aluno
        int novoSaldo = aluno.getSaldoMoedas() - cupom.getCustoMoedas();
        aluno.setSaldoMoedas(novoSaldo);
        alunoRepository.save(aluno);// salva o aluno com o novo saldo

        //diminui a quantidade de cupons
        cupom.setQuantidadeCupm(cupom.getQuantidadeCupm() - 1);
        //salvar nova quantidade do cupom
        
        return vantagemRepository.save(cupom);
    }

}
