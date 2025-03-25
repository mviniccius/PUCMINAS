package com.aluguel.carros.service;


import com.aluguel.carros.model.RentEntity;
import com.aluguel.carros.repository.CarsRepository;
import com.aluguel.carros.repository.RentRepository;
import com.aluguel.carros.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarsRepository carsRepository;

    public RentEntity alugarCarro(RentEntity aluguel){

        var user = userRepository.findById(aluguel.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        var carro = carsRepository.findById(aluguel.getCarId())
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));


        return rentRepository.save(aluguel);
    }
    public List<RentEntity> listarTodosContratos(){
        return rentRepository.findAll();
    }

    public void excluir(String id){
        rentRepository.deleteById(id);
    }
}
