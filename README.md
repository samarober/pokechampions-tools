# ⚔️ Pokémon Champions Tools

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![React](https://img.shields.io/badge/React-18-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Ready-2496ED?style=for-the-badge&logo=docker&logoColor=white)

Plataforma web Full Stack diseñada específicamente para el ecosistema competitivo de **Pokémon Champions**. Proporciona herramientas avanzadas para la gestión de equipos y el análisis de daño, apoyadas en una arquitectura de datos híbrida de alto rendimiento.

## 🚀 Características Principales

* **Pokedex/Megadex Inteligente:** Consulta instantánea de stats, tipos y habilidades.
* **Team Builder Avanzado:** Creador de equipos adaptado al sistema de EVs específico de Pokémon Champions.
* **Calculadora de Daño:** Resolución de combates 1v1, cálculo de daño por movimiento y optimización matemática de EVs.

## 🏗️ Arquitectura del Sistema

El proyecto utiliza una arquitectura de **Monorepo** que integra un frontend moderno, un backend robusto y una base de datos relacional, orquestados mediante Docker para facilitar el desarrollo y el despliegue.

### 1. El Patrón de Datos Híbrido (Core Backend)
El mayor desafío de este proyecto es mantener sincronizados los datos oficiales de Pokémon con los balances (buffs/nerfs) específicos de *Pokémon Champions*. Se ha resuelto implementando el **Patrón de Sobrescritura (Override Pattern)** en PostgreSQL:

* `pokemon_base`: Almacena los datos oficiales (extraídos vía PokéAPI).
* `pokemon_override`: Almacena exclusivamente las modificaciones manuales o custom (Megas, cambios de tipo/stats).
* `vw_pokemon_active`: Una vista SQL de lectura que fusiona ambas tablas en tiempo real usando `COALESCE`, proporcionando al Backend la **Fuente de Verdad Final** sin duplicar datos.

### 2. Stack y Patrones Backend (Spring Boot)
* **Gestión de Base de Datos:** Flyway para migraciones versionadas y Spring Data JPA para el acceso a datos.
* **Transferencia de Datos:** Implementación estricta de DTOs (`Records` de Java) mapeados automáticamente mediante **MapStruct** para aislar el modelo de dominio.
* **Control de Errores:** Uso de `@RestControllerAdvice` para capturar excepciones globalmente y devolver respuestas JSON predecibles al frontend.
* **Paginación Nativa:** Implementada en la capa de repositorios para manejar grandes volúmenes de datos sin penalizar la memoria del servidor.
* **Documentación:** API documentada automáticamente con OpenAPI (Swagger).

## 🛠️ Guía de Desarrollo Local

### Prerrequisitos
* Docker & Docker Compose
* Java 17 o superior
* Node.js 18 o superior

### Levantando el Entorno

**1. Base de Datos (Infraestructura)**
Levanta el contenedor de PostgreSQL en segundo plano:
\`\`\`bash
docker-compose up -d
\`\`\`

**2. Backend (API)**
Las migraciones de Flyway crearán el esquema automáticamente al arrancar.
\`\`\`bash
cd backend
./mvnw spring-boot:run
\`\`\`
* Swagger UI disponible en: `http://localhost:8080/swagger-ui/index.html`

**3. Frontend (UI)**
\`\`\`bash
cd frontend
npm install
npm run dev
\`\`\`

## 📌 Estado del Proyecto
*Consulta el archivo [STATE.md](./backend/STATE.md) para ver el progreso detallado de las fases de desarrollo.*