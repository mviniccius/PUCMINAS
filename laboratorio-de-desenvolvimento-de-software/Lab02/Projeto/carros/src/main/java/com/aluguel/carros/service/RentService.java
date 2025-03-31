package com.aluguel.carros.service;


import com.aluguel.carros.model.CarsEntity;
import com.aluguel.carros.model.RentEntity;
import com.aluguel.carros.repository.CarsRepository;
import com.aluguel.carros.repository.RentRepository;
import com.aluguel.carros.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentService {

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarsRepository carsRepository;

    public RentEntity alugarCarro(RentEntity aluguel){

        Optional<CarsEntity> carroOpt = carsRepository.findById(aluguel.getCarId());

        if (carroOpt.isPresent() && carroOpt.get().isDisponivel()){
            CarsEntity carro = carroOpt.get();
            carro.setDisponivel(false);
            carsRepository.save(carro);
        }
        return rentRepository.save(aluguel);
    }
    public List<RentEntity> listarTodosContratos(){
        return rentRepository.findAll();
    }

    public void excluir(String id){
        rentRepository.deleteById(id);
    }
}