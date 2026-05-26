package com.CineSpring.desafio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Filme")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 50, nullable = false)
    @NotBlank
    private String titulo;

    @Column(name = "director", length = 150, nullable = false)
    @NotBlank
    private String diretor;

    @Column(name = "releaseYear")
    @Min(1888)
    @Max(2026)
    private int anoLancamento;

    @Column(name = "genre", length = 150, nullable = false)
    @NotBlank
    private String genero;

}
