package com.pokechampionstools.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.pokechampionstools.backend.domain.dto.PokemonActiveDto;
import com.pokechampionstools.backend.domain.entity.PokemonActive;

@Mapper
public interface PokemonMapper {
    
    PokemonMapper INSTANCE = Mappers.getMapper(PokemonMapper.class);

    PokemonActiveDto toDto(PokemonActive entity);
}