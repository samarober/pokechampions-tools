package com.pokechampionstools.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.pokechampionstools.backend.domain.entity.PokemonActive;

@org.springframework.stereotype.Repository
public interface PokemonActiveRepository extends Repository<PokemonActive, Integer> {
    
    // Cambiamos List por Page, y le pasamos el objeto Pageable
    Page<PokemonActive> findAll(Pageable pageable);
    
    Optional<PokemonActive> findById(Integer pokedexNumber);
    
    List<PokemonActive> findByNameContainingIgnoreCase(String name);
}