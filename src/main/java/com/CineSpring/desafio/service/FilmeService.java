package com.CineSpring.desafio.service;

import com.CineSpring.desafio.dtos.FilmeRequestDTO;
import com.CineSpring.desafio.dtos.FilmeResponseDTO;
import com.CineSpring.desafio.exception.FilmeNotFoundException;
import com.CineSpring.desafio.mappers.FilmeMapper;
import com.CineSpring.desafio.model.Filme;
import com.CineSpring.desafio.repository.FilmeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {
    private final FilmeRepository filmeRepository;
    private final FilmeMapper filmeMapper;

    public FilmeService(FilmeRepository filmeRepository, FilmeMapper filmeMapper) {
        this.filmeRepository = filmeRepository;
        this.filmeMapper = filmeMapper;
    }

    @Transactional
    public FilmeResponseDTO save(FilmeRequestDTO filme){
       Filme filmeEntity = filmeMapper.toEntity(filme);
       Filme filmeSalvo = filmeRepository.save(filmeEntity);
       return filmeMapper.toResponse(filmeSalvo);
    }

    @Transactional(readOnly = true)
    public List<FilmeResponseDTO> findAll(){
        return filmeRepository.findAll().stream().map(filmeMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public FilmeResponseDTO findById(Long id){
        Optional<FilmeResponseDTO> obj = filmeRepository.findById(id).map(filmeMapper::toResponse);
        return obj.orElseThrow(() -> new FilmeNotFoundException(id));
    }

}
