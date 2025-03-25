package com.aluguel.carros.repository;

import com.aluguel.carros.model.CarsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends MongoRepository<CarsEntity, String> {
}
