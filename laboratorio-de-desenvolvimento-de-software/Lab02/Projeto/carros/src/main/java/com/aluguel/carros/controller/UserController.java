package com.aluguel.carros.controller;


import com.aluguel.carros.dto.LoginRequest;
import com.aluguel.carros.model.UserEntity;
import com.aluguel.carros.repository.UserRepository;
import com.aluguel.carros.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

   @Autowired
    private UserService userService;

   @Autowired
   private UserRepository userRepository;


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
   @PutMapping("/{id}")
    public UserEntity atualizar(@PathVariable String id, @RequestBody UserEntity user){
       return userService.atualizar(id, user);
   }
   @PostMapping("/login")
    public ResponseEntity<?> autenticar(@RequestBody LoginRequest login){
       Optional<UserEntity> usuario = userRepository.findByEmailAndSenha(
               login.getEmail(),
               login.getEmail()
       );

       if(usuario.isPresent()){
           UserEntity u = usuario.get();
           u.setSenha(null);
           return ResponseEntity.ok(u);
       }else {
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Errou");
       }
   }

}
