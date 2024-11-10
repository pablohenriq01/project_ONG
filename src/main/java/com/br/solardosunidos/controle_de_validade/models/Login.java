package com.br.solardosunidos.controle_de_validade.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "tb_login")
public class Login {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;

}
