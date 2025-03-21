package com.aluguel.carros.service;


import com.aluguel.carros.model.UserEntity;
import com.aluguel.carros.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.jta.UserTransactionAdapter;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<UserEntity>listarTodos(){
        return userRepository.findAll();
    }

    public UserEntity obterPorId(String id){
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity novoUsuario(UserEntity usuario){
        return userRepository.save(usuario);
    }

    public void excluir(String id){
        userRepository.deleteById(id);
    }

}
