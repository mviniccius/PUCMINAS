package com.moedas.service;


import com.moedas.model.Vantagem;
import com.moedas.repository.VantagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VantagemService {

    @Autowired
    private VantagemRepository vantagemRepository;

    //lista todas as vantagens com quantidade maior que 0
    public List<Vantagem> listarDisponiveis(){
        return vantagemRepository.findAll()
                .stream()
                .filter(v -> v.getQuantidadeCupm() >0)
                .collect(Collectors.toList());
    }

    public Vantagem comprarCupom(String idVantagem){
        //buscar cupom pelo ID
        Vantagem cupom = vantagemRepository.findById(idVantagem).orElse(null);

        //verifica se o cupom existe
        if (cupom == null){
            throw new RuntimeException("Cupom nao encontrado");
        }

        //verifica se a quantidade de cupom esta disponivel
        if(cupom.getQuantidadeCupm() <= 0){
            throw new RuntimeException("Cupom esgotado");
        }

        //diminui a quantidade de cupons
        cupom.setQuantidadeCupm(cupom.getQuantidadeCupm() - 1);

        //salvar nova quantidade do cupom
        return vantagemRepository.save(cupom);
    }

}
