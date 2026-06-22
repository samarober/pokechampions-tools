package com.pokechampionstools.backend.repository;

import com.pokechampionstools.backend.domain.entity.PokemonBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonBaseRepository extends JpaRepository<PokemonBase, Long> {
}