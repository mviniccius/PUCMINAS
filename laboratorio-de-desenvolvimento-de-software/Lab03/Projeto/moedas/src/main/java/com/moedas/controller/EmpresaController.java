package com.moedas.controller;

import com.moedas.model.Empresa;
import com.moedas.model.Vantagem;
import com.moedas.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/{id}/vantagens")
    public ResponseEntity<Vantagem> cadastrarVantagem(@PathVariable String id, @RequestBody Vantagem vantagem){
        Vantagem nova = empresaService.cadastrarVantagem(id, vantagem);
        return ResponseEntity.ok(nova);
    }
}
