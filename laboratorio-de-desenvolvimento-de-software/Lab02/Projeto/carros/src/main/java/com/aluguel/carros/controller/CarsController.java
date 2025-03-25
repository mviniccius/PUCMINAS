package com.aluguel.carros.controller;


import com.aluguel.carros.model.CarsEntity;
import com.aluguel.carros.repository.CarsRepository;
import com.aluguel.carros.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarsService carsService;

    @GetMapping
    public List<CarsEntity>listarTodos(){
        return carsService.listarTodosCarros();
    }

    @PostMapping
    public CarsEntity novoCarro(@RequestBody CarsEntity novoCarro){
        return carsService.novoCarro(novoCarro);
    }

    @DeleteMapping("/{id}")
    public void excluirCarro(@PathVariable String id){
        carsService.excluirCarro(id);
    }

}
