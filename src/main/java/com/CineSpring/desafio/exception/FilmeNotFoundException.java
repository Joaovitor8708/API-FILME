package com.CineSpring.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FilmeNotFoundException extends RuntimeException {
    public FilmeNotFoundException(Long id) {
        super("Filme não encontrado!");
    }
}
