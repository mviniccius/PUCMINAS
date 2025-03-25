package com.aluguel.carros.controller;


import com.aluguel.carros.model.RentEntity;
import com.aluguel.carros.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rent")
public class RentController {


    @Autowired
    private RentService rentService;


    @GetMapping
    public List<RentEntity> listarTodos(){
        return rentService.listarTodosContratos();
    }

    @PostMapping
    public RentEntity novoContrato(@RequestBody RentEntity aluguel){
        return rentService.alugarCarro(aluguel);
    }

    @DeleteMapping("/{id}")
    public void exclui(@PathVariable String id){
        rentService.excluir(id);
    }
}
