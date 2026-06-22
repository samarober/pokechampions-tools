package com.pokechampionstools.backend.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pokemon_base")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PokemonBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pokedex_number", unique = true, nullable = false)
    private Integer pokedexNumber;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "type_1", nullable = false, length = 50)
    private String type1;

    @Column(name = "type_2", length = 50)
    private String type2;

    @Column(name = "base_hp", nullable = false)
    private Integer baseHp;

    @Column(name = "base_attack", nullable = false)
    private Integer baseAttack;

    @Column(name = "base_defense", nullable = false)
    private Integer baseDefense;

    @Column(name = "base_sp_attack", nullable = false)
    private Integer baseSpAttack;

    @Column(name = "base_sp_defense", nullable = false)
    private Integer baseSpDefense;

    @Column(name = "base_speed", nullable = false)
    private Integer baseSpeed;

    @Column(name = "sprite_url")
    private String spriteUrl;
}