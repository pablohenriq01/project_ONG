package com.br.solardosunidos.controle_de_validade.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserDTO(@NotNull String name,
                     @NotNull @Email String email,
                      @NotNull String password) {
}
