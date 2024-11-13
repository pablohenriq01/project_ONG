package com.br.solardosunidos.controle_de_validade.controllers;

import com.br.solardosunidos.controle_de_validade.DTOs.UserDTO;
import com.br.solardosunidos.controle_de_validade.models.User;
import com.br.solardosunidos.controle_de_validade.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUsers(@Valid @RequestBody UserDTO user){
        try {
            userService.registerUser(user);
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@RequestBody @PathVariable("id") Long id){
        try {
            User user = userService.listUserID(id);
            return ResponseEntity.ok(user);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<List<User>> findAll(){
        try {
            List<User> users = userService.listAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
