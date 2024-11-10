package com.br.solardosunidos.controle_de_validade.repositories;

import com.br.solardosunidos.controle_de_validade.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
