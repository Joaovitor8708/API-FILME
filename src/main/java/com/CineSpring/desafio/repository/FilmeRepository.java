package com.CineSpring.desafio.repository;

import com.CineSpring.desafio.model.Filme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
