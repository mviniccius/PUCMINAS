package com.moedas.controller;


import com.moedas.dto.LoginDTO;
import com.moedas.model.Aluno;
import com.moedas.model.Empresa;
import com.moedas.service.AlunoService;
import com.moedas.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        // Tenta autenticar como aluno
        if (loginDTO.getTipoLogin().equals("aluno")) {
            Aluno aluno = alunoService.autenticarAluno(loginDTO.getEmail(), loginDTO.getSenha());
            if (aluno != null) {
                aluno.setTipo("aluno");
                return ResponseEntity.ok(aluno);
            }
        } else if (loginDTO.getTipoLogin().equals("empresa")) {
            // Tenta autenticar como empresa
            Empresa empresa = empresaService.autenticarEmpresa(loginDTO.getEmail(), loginDTO.getSenha());
            if (empresa != null) {
                empresa.setTipo("empresa");
                return ResponseEntity.ok(empresa);
            }
        } else if (loginDTO.getTipoLogin().equals("3")) {
            //fazer tipo 3 = professor
        }
            // Nenhum encontrado
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");

    }
}
