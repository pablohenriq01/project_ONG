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
            return new ResponseEntity<>(users,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        try{
            User user = userService.listUserID(id);
            userService.deleteUser(user);
            return new ResponseEntity<>("Usuario excluido",HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Usuario não localizado no BD",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody User user){
        try{
            userService.updateUser(id, user);
            return new ResponseEntity<>("Usuario atualizado",HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Usuario não localizado no BD",HttpStatus.BAD_REQUEST);
        }
    }
}
