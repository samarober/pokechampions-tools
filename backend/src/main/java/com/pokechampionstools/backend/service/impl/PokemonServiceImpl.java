package com.pokechampionstools.backend.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pokechampionstools.backend.domain.dto.PokemonActiveDto;
import com.pokechampionstools.backend.mapper.PokemonMapper;
import com.pokechampionstools.backend.repository.PokemonActiveRepository;
import com.pokechampionstools.backend.service.PokemonService;

import lombok.RequiredArgsConstructor;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonActiveRepository pokemonRepository;
    // Usamos la instancia nativa en lugar de pedirla por inyecciÃ³n de dependencias
    private final PokemonMapper pokemonMapper = PokemonMapper.INSTANCE;

    public PokemonServiceImpl(PokemonActiveRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public Page<PokemonActiveDto> getAllPokemon(Pageable pageable) {
        // Obtenemos la pÃ¡gina de entidades y la mapeamos a DTOs
        return pokemonRepository.findAll(pageable)
                .map(pokemonMapper::toDto);
    }

    @Override
    public PokemonActiveDto getPokemonByPokedexNumber(Integer pokedexNumber) {
        return pokemonRepository.findById(pokedexNumber)
                .map(pokemonMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException("No se encontrÃ³ ningÃºn PokÃ©mon con el nÃºmero de PokÃ©dex: " + pokedexNumber));
    }

    @Override
    public List<PokemonActiveDto> searchPokemonByName(String name) {
        return pokemonRepository.findByNameContainingIgnoreCase(name).stream()
                .map(pokemonMapper::toDto)
                .collect(Collectors.toList());
    }
}