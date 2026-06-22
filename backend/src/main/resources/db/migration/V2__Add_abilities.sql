-- 1. Añadir columnas a la tabla base
ALTER TABLE pokemon_base
ADD COLUMN ability_1 VARCHAR(50) NOT NULL DEFAULT 'Unknown',
ADD COLUMN ability_2 VARCHAR(50),
ADD COLUMN hidden_ability VARCHAR(50);

-- 2. Añadir columnas a la tabla de overrides
ALTER TABLE pokemon_override
ADD COLUMN custom_ability_1 VARCHAR(50),
ADD COLUMN custom_ability_2 VARCHAR(50),
ADD COLUMN custom_hidden_ability VARCHAR(50);

-- 3. Recrear la vista para incluir las nuevas columnas con la lógica COALESCE
DROP VIEW IF EXISTS vw_pokemon_active;

CREATE VIEW vw_pokemon_active AS
SELECT 
    COALESCE(o.custom_pokedex_number, b.pokedex_number) AS pokedex_number,
    COALESCE(o.custom_name, b.name) AS name,
    COALESCE(o.custom_type_1, b.type_1) AS type_1,
    COALESCE(o.custom_type_2, b.type_2) AS type_2,
    COALESCE(o.custom_ability_1, b.ability_1) AS ability_1,
    COALESCE(o.custom_ability_2, b.ability_2) AS ability_2,
    COALESCE(o.custom_hidden_ability, b.hidden_ability) AS hidden_ability,
    COALESCE(o.custom_base_hp, b.base_hp) AS base_hp,
    COALESCE(o.custom_base_attack, b.base_attack) AS base_attack,
    COALESCE(o.custom_base_defense, b.base_defense) AS base_defense,
    COALESCE(o.custom_base_sp_attack, b.base_sp_attack) AS base_sp_attack,
    COALESCE(o.custom_base_sp_defense, b.base_sp_defense) AS base_sp_defense,
    COALESCE(o.custom_base_speed, b.base_speed) AS base_speed,
    b.sprite_url
FROM pokemon_base b
LEFT JOIN pokemon_override o ON b.id = o.pokemon_base_id
WHERE o.is_active IS NOT FALSE;