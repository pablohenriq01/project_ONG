package com.br.solardosunidos.controle_de_validade.controllers;

import com.br.solardosunidos.controle_de_validade.DTOs.ProductDTO;
import com.br.solardosunidos.controle_de_validade.models.Product;
import com.br.solardosunidos.controle_de_validade.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/register")
    public ResponseEntity<ProductDTO> register(@Valid @RequestBody ProductDTO productDTO){
        try{
            productService.registerProduct(productDTO);
            return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
