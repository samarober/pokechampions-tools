package com.pokechampionstools.backend.mapper;

import com.pokechampionstools.backend.domain.dto.PokemonActiveDto;
import com.pokechampionstools.backend.domain.entity.PokemonActive;
import org.mapstruct.Mapper;

// componentModel = "spring" le dice a MapStruct que convierta este mapper en un @Component de Spring
@Mapper(componentModel = "spring")
public interface PokemonMapper {

    // MapStruct autogenerará el código de este método al compilar
    PokemonActiveDto toDto(PokemonActive entity);
}