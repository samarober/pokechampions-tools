package com.pokechampionstools.backend.repository;

import com.pokechampionstools.backend.domain.entity.PokemonOverride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonOverrideRepository extends JpaRepository<PokemonOverride, Long> {
}