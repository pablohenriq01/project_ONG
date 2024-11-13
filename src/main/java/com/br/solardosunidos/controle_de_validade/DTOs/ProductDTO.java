package com.br.solardosunidos.controle_de_validade.DTOs;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ProductDTO(@NotNull String nameProduct,
                         @NotNull Date expirationDate,
                         @NotNull Long userID) {
}
