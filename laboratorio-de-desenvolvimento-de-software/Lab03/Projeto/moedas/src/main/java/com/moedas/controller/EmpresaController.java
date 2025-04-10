package com.moedas.controller;

import com.moedas.model.Empresa;
import com.moedas.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<Empresa>listarTodos(){
        return empresaService.listarEmpresas();
    }
    @PostMapping
    public Empresa cadastrarEmpresa(@RequestBody Empresa empresa){
       return empresaService.salvar(empresa);
    }
}
