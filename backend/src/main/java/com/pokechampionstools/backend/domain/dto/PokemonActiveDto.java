package com.pokechampionstools.backend.domain.dto;

public record PokemonActiveDto(
    Integer pokedexNumber,
    String name,
    String type1,
    String type2,
    String ability1,
    String ability2,
    String hiddenAbility,
    Integer baseHp,
    Integer baseAttack,
    Integer baseDefense,
    Integer baseSpAttack,
    Integer baseSpDefense,
    Integer baseSpeed,
    String spriteUrl
) {}