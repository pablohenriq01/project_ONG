package com.br.solardosunidos.controle_de_validade.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @Column(name = "name", nullable = false)
    private String nameProduct;

    @NotNull
    @Column(name = "expiration_date", nullable = false)
    private Date expirationDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_userID", nullable = false)
    private User userRegister;

    public Product(String nameProduct, Date expirationDate, User userRegister) {
        this.nameProduct = nameProduct;
        this.expirationDate = expirationDate;
        this.userRegister = userRegister;
    }
}