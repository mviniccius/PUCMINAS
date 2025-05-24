package com.moedas.controller;

import com.moedas.dto.EnvioMoedasDTO;
import com.moedas.model.Professor;
import com.moedas.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @GetMapping
    public List<Professor>listarTodos(){
        return professorService.listarTodosProfessores();
    }

    @PostMapping
    public Professor cadastrarProfessor(@RequestBody Professor professor){
        return professorService.salvar(professor);
    }


    @PostMapping("/{idProfessor}/enviar-moedas")
    public ResponseEntity<?> enviarMoedas(
            @PathVariable String idProfessor,
            @RequestBody EnvioMoedasDTO dto){
        try {
            professorService.enviarMoedas(idProfessor, dto.getIdAluno(), dto.getValor(), dto.getDescricao());
            return ResponseEntity.ok().build();
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
