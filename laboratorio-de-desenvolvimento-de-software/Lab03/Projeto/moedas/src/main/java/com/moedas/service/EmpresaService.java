package com.moedas.service;


import com.moedas.model.Empresa;
import com.moedas.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> listarEmpresas(){
        return empresaRepository.findAll();
    }

    public Empresa salvar(Empresa empresa){
        empresa.setTipo("empresa");
        return empresaRepository.save(empresa);
    }
}
