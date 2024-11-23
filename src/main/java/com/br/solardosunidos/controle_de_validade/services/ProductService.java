package com.br.solardosunidos.controle_de_validade.services;

import com.br.solardosunidos.controle_de_validade.DTOs.ProductDTO;
import com.br.solardosunidos.controle_de_validade.models.Product;
import com.br.solardosunidos.controle_de_validade.models.User;
import com.br.solardosunidos.controle_de_validade.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserService userService;
    public void registerProduct(ProductDTO productDTO){
        String nameProduct = productDTO.nameProduct();
        Date expirationDate = productDTO.expirationDate();
        Long userID = productDTO.userID();

        User user = userService.listUserID(userID);
        Product product = new Product(nameProduct, expirationDate, user);
        productRepository.save(product);
    }

    public Product listProductId(Long id){
        return productRepository.findById(id).get();
    }

    public List<Product> listAllProducts(){
        return productRepository.findAll();
    }

    public void deleteProduct(Product product){
        productRepository.delete(product);
    }

    public void updateProduct(Long id, ProductDTO productDTO){
        Product productUpdate = listProductId(id);

        productUpdate.setNameProduct(productDTO.nameProduct());
        productUpdate.setExpirationDate(productDTO.expirationDate());
        productUpdate.setUserRegister(userService.listUserID(productDTO.userID()));

        productRepository.save(productUpdate);
    }
}
