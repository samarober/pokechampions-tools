package com.pokechampionstools.backend.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pokechampionstools.backend.domain.dto.PokemonActiveDto;

public interface PokemonService {
    Page<PokemonActiveDto> getAllPokemon(Pageable pageable);
    PokemonActiveDto getPokemonByPokedexNumber(Integer pokedexNumber);
    List<PokemonActiveDto> searchPokemonByName(String name);
}