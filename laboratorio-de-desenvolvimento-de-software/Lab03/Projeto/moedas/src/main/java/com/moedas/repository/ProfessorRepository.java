package com.moedas.repository;

import com.moedas.model.Professor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfessorRepository extends MongoRepository<Professor, String> {
}
