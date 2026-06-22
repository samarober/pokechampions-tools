-- 1. Tabla para los datos base importados de la API externa (PokéAPI)
CREATE TABLE pokemon_base (
    id SERIAL PRIMARY KEY,
    pokedex_number INT UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    type_1 VARCHAR(50) NOT NULL,
    type_2 VARCHAR(50),
    base_hp INT NOT NULL,
    base_attack INT NOT NULL,
    base_defense INT NOT NULL,
    base_sp_attack INT NOT NULL,
    base_sp_defense INT NOT NULL,
    base_speed INT NOT NULL,
    sprite_url VARCHAR(255)
);

-- 2. Tabla para modificaciones específicas de Pokémon Champions u Overrides manuales
CREATE TABLE pokemon_override (
    id SERIAL PRIMARY KEY,
    pokemon_base_id INT REFERENCES pokemon_base(id) ON DELETE CASCADE,
    custom_pokedex_number INT, -- Para Megas o formas regionales con numeración propia
    custom_name VARCHAR(100),
    custom_type_1 VARCHAR(50),
    custom_type_2 VARCHAR(50),
    custom_base_hp INT,
    custom_base_attack INT,
    custom_base_defense INT,
    custom_base_sp_attack INT,
    custom_base_sp_defense INT,
    custom_base_speed INT,
    is_active BOOLEAN DEFAULT TRUE NOT NULL
);

-- 3. Vista de la Fuente de la Verdad Final (Une ambas tablas priorizando los Overrides)
CREATE VIEW vw_pokemon_active AS
SELECT 
    COALESCE(o.custom_pokedex_number, b.pokedex_number) AS pokedex_number,
    COALESCE(o.custom_name, b.name) AS name,
    COALESCE(o.custom_type_1, b.type_1) AS type_1,
    COALESCE(o.custom_type_2, b.type_2) AS type_2,
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