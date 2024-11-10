package com.br.solardosunidos.controle_de_validade.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    private Long id;
    @Column(name = "name")
    private String nameProduct;
    @Column(name = "expiration_date")
    private Date expirationDate;
}