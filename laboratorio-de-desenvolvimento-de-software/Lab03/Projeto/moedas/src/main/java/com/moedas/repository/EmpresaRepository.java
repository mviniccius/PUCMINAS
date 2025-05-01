package com.moedas.repository;

import com.moedas.model.Empresa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpresaRepository extends MongoRepository<Empresa, String> {
    Empresa findByEmail(String email);
}
