package com.aluguel.carros.controller;


import com.aluguel.carros.model.CarsEntity;
import com.aluguel.carros.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Map;
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

    @GetMapping("/disponiveis")
    public List<CarsEntity> listarDisponiveis(){
        return carsService.listarCarrosDisponiveis();
    }

    @GetMapping("/{id}")
    public CarsEntity buscarCarroPorId(@PathVariable String id) {
        return carsService.buscarCarroPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarsEntity> atualizarDisponibilidade(@PathVariable String id, @RequestBody Map<String, Object> body) {
        CarsEntity carroExistente = carsService.buscarCarroPorId(id);

        if (body.containsKey("disponivel")) {
            boolean novoStatus = Boolean.parseBoolean(body.get("disponivel").toString());
            carroExistente.setDisponivel(novoStatus);
        }

        CarsEntity atualizado = carsService.novoCarro(carroExistente);
        return ResponseEntity.ok(atualizado);
    }


}
