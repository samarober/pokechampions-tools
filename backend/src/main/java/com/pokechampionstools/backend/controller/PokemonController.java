package com.pokechampionstools.backend.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pokechampionstools.backend.domain.dto.PokemonActiveDto;
import com.pokechampionstools.backend.service.PokemonService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/pokemon")
@Tag(name = "Pokedex", description = "Endpoints para la Pokedex y Megadex de Pokemon Champions")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    @Operation(summary = "Obtener lista paginada de Pokemon", description = "Devuelve una pagina de Pokemon activos en el meta actual.")
    public ResponseEntity<Page<PokemonActiveDto>> getAllPokemon(
            @ParameterObject @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(pokemonService.getAllPokemon(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un Pokemon por su numero de Pokedex", description = "Devuelve los detalles exactos (incluyendo overrides) de un Pokemon especifico.")
    public ResponseEntity<PokemonActiveDto> getPokemonById(@PathVariable Integer id) {
        return ResponseEntity.ok(pokemonService.getPokemonByPokedexNumber(id));
    }

    @GetMapping("/search")
    @Operation(summary = "Buscar Pokemon por nombre", description = "Busqueda parcial insensible a mayusculas/minusculas.")
    public ResponseEntity<List<PokemonActiveDto>> searchPokemon(@RequestParam String name) {
        return ResponseEntity.ok(pokemonService.searchPokemonByName(name));
    }
}