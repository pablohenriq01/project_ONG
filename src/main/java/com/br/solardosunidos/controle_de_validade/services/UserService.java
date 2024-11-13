package com.br.solardosunidos.controle_de_validade.services;

import com.br.solardosunidos.controle_de_validade.DTOs.UserDTO;
import com.br.solardosunidos.controle_de_validade.models.User;
import com.br.solardosunidos.controle_de_validade.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void registerUser(UserDTO userDTO){
        String name = userDTO.name();
        String email = userDTO.email();
        String password = userDTO.password();

        User user = new User(name,email,password);
        userRepository.save(user);
    }

    public User listUserID(Long id){
        return userRepository.findById(id).get();
    }

    public List<User> listAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public void updateUser(Long id, User user){
        User userUpdate = listUserID(id);

        userUpdate.setName(user.getName());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setPassword(user.getPassword());

        userRepository.save(userUpdate);
    }
}
