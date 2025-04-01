package com.aluguel.carros.service;


import com.aluguel.carros.model.CarsEntity;
import com.aluguel.carros.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarsService {

    @Autowired
    private CarsRepository carsRepository;


    public List<CarsEntity>listarTodosCarros(){
        return carsRepository.findAll();
    }

    public List<CarsEntity>listarCarrosDisponiveis(){
        return carsRepository.findByDisponivelTrue();
    }

    public CarsEntity novoCarro(CarsEntity carro){
        return carsRepository.save(carro);
    }

    public void excluirCarro(String id){
        carsRepository.deleteById(id);
    }

    public CarsEntity buscarCarroPorId(String id) {
        return carsRepository.findById(id).orElse(null);
    }

}
