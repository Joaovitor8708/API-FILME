package com.CineSpring.desafio.controller;

import com.CineSpring.desafio.dtos.FilmeRequestDTO;
import com.CineSpring.desafio.dtos.FilmeResponseDTO;
import com.CineSpring.desafio.service.FilmeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filmes")
public class FilmeController {
    public final FilmeService service;

    public FilmeController(FilmeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FilmeResponseDTO> save(@RequestBody @Valid FilmeRequestDTO filme){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(filme));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<FilmeResponseDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

}
