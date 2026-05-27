package com.CineSpring.desafio.dtos;

import jakarta.validation.constraints.*;

public record FilmeRequestDTO(

        @NotBlank
        @Size(min = 2, max = 50)
        String titulo,

        @NotBlank
        @Size(min = 4, max = 150)
        String diretor,

        @Min(1888)
        @Max(2026)
        int anoLancamento,

        @NotBlank
        @Size(min = 4, max = 150)
        String genero
) {
}
