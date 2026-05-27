package com.CineSpring.desafio.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Filme")
@Data
@NoArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 50, nullable = false)
    private String titulo;

    @Column(name = "director", length = 150, nullable = false)
    private String diretor;

    @Column(name = "releaseYear")
    private int anoLancamento;

    @Column(name = "genre", length = 150, nullable = false)
    private String genero;

    public Filme(String titulo, String diretor, int anoLancamento, String genero){
        this.titulo = titulo;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
    }

}
