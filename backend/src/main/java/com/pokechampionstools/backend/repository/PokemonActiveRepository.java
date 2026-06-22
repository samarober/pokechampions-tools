package com.pokechampionstools.backend.repository;

import com.pokechampionstools.backend.domain.entity.PokemonActive;
import org.springframework.data.repository.Repository;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface PokemonActiveRepository extends Repository<PokemonActive, Integer> {
    
    // Spring Data genera la query SQL automáticamente por el nombre del método
    List<PokemonActive> findAll();
    
    Optional<PokemonActive> findById(Integer pokedexNumber);
    
    List<PokemonActive> findByNameContainingIgnoreCase(String name);
}