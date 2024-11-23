package com.br.solardosunidos.controle_de_validade.controllers;

import com.br.solardosunidos.controle_de_validade.DTOs.ProductDTO;
import com.br.solardosunidos.controle_de_validade.models.Product;
import com.br.solardosunidos.controle_de_validade.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@RequestBody @PathVariable("id") Long id){
        try {
            Product product = productService.listProductId(id);
            return ResponseEntity.ok(product);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Product>> findAll(){
        try {
            List<Product> products = productService.listAllProducts();
            return new ResponseEntity<>(products,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        try{
            Product product = productService.listProductId(id);
            productService.deleteProduct(product);
            return new ResponseEntity<>("Produto excluido",HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Produto não localizado no BD",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO){
        try{
            productService.updateProduct(id, productDTO);
            return new ResponseEntity<>("Produto atualizado",HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Produto não localizado no BD",HttpStatus.BAD_REQUEST);
        }
    }
}
