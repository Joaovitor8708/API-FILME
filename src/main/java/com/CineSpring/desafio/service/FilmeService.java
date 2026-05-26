package com.CineSpring.desafio.service;

import com.CineSpring.desafio.model.Filme;
import com.CineSpring.desafio.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {
    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    public Filme save(Filme filme){
        return repository.save(filme);
    }

    public List<Filme> findAll(){
        return repository.findAll();
    }

    public Filme findById(Long id){
        Optional<Filme> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    }


}
