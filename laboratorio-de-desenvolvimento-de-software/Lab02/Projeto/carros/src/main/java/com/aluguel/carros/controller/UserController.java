package com.aluguel.carros.controller;


import com.aluguel.carros.model.UserEntity;
import com.aluguel.carros.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

   @Autowired
    private UserService userService;

   @GetMapping
    public List<UserEntity>listarTodos(){
       return userService.listarTodos();
   }
   @GetMapping("/{id}")
    public UserEntity obterPorId(@PathVariable String id){
       return userService.obterPorId(id);
   }
   @PostMapping
    public UserEntity novoUsuario(@RequestBody UserEntity usuario){
       return userService.novoUsuario(usuario);
   }
   @DeleteMapping("/{id}")
    public void excluir(@PathVariable String id){
       userService.excluir(id);
   }

}
