CREATE OR REPLACE VIEW vw_pokemon_active AS
SELECT
    pokedex_number,
    name,
    type_1,
    type_2,
    ability_1,
    ability_2,
    hidden_ability,
    base_hp,
    base_attack,
    base_defense,
    base_sp_attack,
    base_sp_defense,
    base_speed,
    sprite_url
FROM pokemon_base;