package com.pokechampionstools.backend.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pokemon_override")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PokemonOverride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con la tabla pokemon_base
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pokemon_base_id")
    private PokemonBase pokemonBase;

    @Column(name = "custom_pokedex_number")
    private Integer customPokedexNumber;

    @Column(name = "custom_name", length = 100)
    private String customName;

    @Column(name = "custom_type_1", length = 50)
    private String customType1;

    @Column(name = "custom_type_2", length = 50)
    private String customType2;

    @Column(name = "custom_ability_1", length = 50)
    private String customAbility1;

    @Column(name = "custom_ability_2", length = 50)
    private String customAbility2;

    @Column(name = "custom_hidden_ability", length = 50)
    private String customHiddenAbility;

    @Column(name = "custom_base_hp")
    private Integer customBaseHp;

    @Column(name = "custom_base_attack")
    private Integer customBaseAttack;

    @Column(name = "custom_base_defense")
    private Integer customBaseDefense;

    @Column(name = "custom_base_sp_attack")
    private Integer customBaseSpAttack;

    @Column(name = "custom_base_sp_defense")
    private Integer customBaseSpDefense;

    @Column(name = "custom_base_speed")
    private Integer customBaseSpeed;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private Boolean isActive = true;
}