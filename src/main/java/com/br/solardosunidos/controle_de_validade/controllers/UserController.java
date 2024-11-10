package com.br.solardosunidos.controle_de_validade.controllers;

import com.br.solardosunidos.controle_de_validade.DTOs.UserDTO;
import com.br.solardosunidos.controle_de_validade.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUsers(@Valid @RequestBody UserDTO user){
        try {
            userService.registerUser(user);
            return new ResponseEntity<>("Criado",HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>("Erro", HttpStatus.BAD_REQUEST);
        }

    }
}
