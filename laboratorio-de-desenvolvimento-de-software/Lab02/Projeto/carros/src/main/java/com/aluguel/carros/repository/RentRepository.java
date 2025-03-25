package com.aluguel.carros.repository;

import com.aluguel.carros.model.RentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RentRepository extends MongoRepository<RentEntity, String> {
}
