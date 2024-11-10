package com.br.solardosunidos.controle_de_validade.models;

import jakarta.persistence.*;
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
    @ManyToOne
    @JoinColumn(name = "fk_loginID")
    private Login loginRegister;
}