package com.CineSpring.desafio.controller;

import com.CineSpring.desafio.model.Filme;
import com.CineSpring.desafio.service.FilmeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    public final FilmeService service;

    public FilmeController(FilmeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Filme> save(@RequestBody @Valid Filme filme){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(filme));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Filme>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

}
