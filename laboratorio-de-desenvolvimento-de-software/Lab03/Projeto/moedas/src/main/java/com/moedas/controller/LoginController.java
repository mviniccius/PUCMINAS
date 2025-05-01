package com.moedas.controller;


import com.moedas.dto.LoginDTO;
import com.moedas.model.Aluno;
import com.moedas.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        Aluno aluno = alunoService.autenticarAluno(loginDTO.getEmail(), loginDTO.getSenha());

        if (aluno == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Errou!");
        }

        return ResponseEntity.ok(aluno); // ou AlunoDTO com dados filtrados
    }
}

