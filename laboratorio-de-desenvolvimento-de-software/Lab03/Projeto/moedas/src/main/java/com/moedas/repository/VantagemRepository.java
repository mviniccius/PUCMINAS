package com.moedas.repository;

import com.moedas.model.Vantagem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VantagemRepository extends MongoRepository<Vantagem, String> {
    List<Vantagem> findByEmpresa_id(String empresaId);
}
