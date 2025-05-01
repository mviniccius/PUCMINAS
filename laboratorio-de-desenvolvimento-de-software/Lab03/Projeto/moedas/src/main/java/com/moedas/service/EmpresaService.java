package com.moedas.service;


import com.moedas.model.Empresa;
import com.moedas.model.Vantagem;
import com.moedas.repository.EmpresaRepository;
import com.moedas.repository.VantagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private VantagemRepository vantagemRepository;

    public List<Empresa> listarEmpresas(){
        return empresaRepository.findAll();
    }

    public Empresa salvar(Empresa empresa){
        empresa.setTipo("empresa");
        return empresaRepository.save(empresa);
    }

    public Empresa autenticarEmpresa(String email, String senha) {
        Empresa empresa = empresaRepository.findByEmail(email);

        // Log para depuração
        System.out.println("Email recebido: " + email);
        if (empresa == null) {
            System.out.println("Empresa não encontrada.");
            return null;
        }

        System.out.println("Senha digitada: " + senha + " | Senha cadastrada: " + empresa.getSenha());

        if (senha != null && empresa.getSenha().equals(senha)) {
            return empresa;
        }

        return null;
    }

    public Vantagem cadastrarVantagem(String empresaId, Vantagem vantagem){
    Empresa empresa = empresaRepository.findById(empresaId).orElse(null);

    if (empresa == null){
        throw new RuntimeException("Empresa nao encontrada");
    }
    vantagem.setEmpresa(empresa);
    return vantagemRepository.save(vantagem);
    }
}
