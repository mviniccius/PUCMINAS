package com.aluguel.carros.service;


import com.aluguel.carros.model.RentEntity;
import com.aluguel.carros.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {

    @Autowired
    private RentRepository rentRepository;

    public RentEntity alugarCarro(RentEntity aluguel){
        return rentRepository.save(aluguel);
    }
    public List<RentEntity> listarTodosContratos(){
        return rentRepository.findAll();
    }
}
