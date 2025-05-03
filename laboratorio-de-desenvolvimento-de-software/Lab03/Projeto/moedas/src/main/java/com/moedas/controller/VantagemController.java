package com.moedas.controller;

import com.moedas.model.Vantagem;
import com.moedas.repository.VantagemRepository;
import com.moedas.service.VantagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vantagens")
public class VantagemController {

    @Autowired
    private VantagemService vantagemService;

    @GetMapping("/disponiveis")
    public List<Vantagem> listarDisponiveis(){
        return vantagemService.listarDisponiveis();
    }

    @PutMapping("{id}/comprar")
    public ResponseEntity<?> comprarCupom(@PathVariable String id){
        try{
            Vantagem atualizado = vantagemService.comprarCupom(id);
            return ResponseEntity.ok(atualizado);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }   
}
