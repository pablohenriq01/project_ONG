package com.br.solardosunidos.controle_de_validade.DTOs;

import java.util.Date;

public record ProductDTO(String nameProduct,
                         Date expirationDate,
                         Long userID) {
}
