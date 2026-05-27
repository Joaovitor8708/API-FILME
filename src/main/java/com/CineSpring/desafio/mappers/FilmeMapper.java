package com.CineSpring.desafio.mappers;

import com.CineSpring.desafio.dtos.FilmeRequestDTO;
import com.CineSpring.desafio.dtos.FilmeResponseDTO;
import com.CineSpring.desafio.model.Filme;
import org.springframework.stereotype.Component;

@Component
public class FilmeMapper {

    public Filme toEntity(FilmeRequestDTO filmeRequestDTO){
        return new Filme(filmeRequestDTO.titulo(), filmeRequestDTO.diretor(), filmeRequestDTO.anoLancamento(), filmeRequestDTO.genero());
    }

    public FilmeResponseDTO toResponse(Filme filme){
        return new FilmeResponseDTO(filme.getTitulo(), filme.getDiretor(), filme.getAnoLancamento(), filme.getGenero());
    }
}
