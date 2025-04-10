package com.moedas.controller;


import com.moedas.model.Aluno;
import com.moedas.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno>listarTodos(){
        return alunoService.listarTodosAlunos();
    }
    @PostMapping
    public Aluno cadastrarAluno(@RequestBody Aluno aluno){
        return alunoService.salvar(aluno);
    }
}
