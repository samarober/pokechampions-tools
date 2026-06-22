package com.pokechampionstools.backend.domain.entity;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Immutable
@Table(name = "vw_pokemon_active")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PokemonActive {

    @Id
    @Column(name = "pokedex_number")
    private Integer pokedexNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "type_1")
    private String type1;

    @Column(name = "type_2")
    private String type2;

    @Column(name = "ability_1")
    private String ability1;

    @Column(name = "ability_2")
    private String ability2;

    @Column(name = "hidden_ability")
    private String hiddenAbility;

    @Column(name = "base_hp")
    private Integer baseHp;

    @Column(name = "base_attack")
    private Integer baseAttack;

    @Column(name = "base_defense")
    private Integer baseDefense;

    @Column(name = "base_sp_attack")
    private Integer baseSpAttack;

    @Column(name = "base_sp_defense")
    private Integer baseSpDefense;

    @Column(name = "base_speed")
    private Integer baseSpeed;

    @Column(name = "sprite_url")
    private String spriteUrl;
}