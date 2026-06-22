# Estado del Proyecto: Pokémon Champions Tools

## Arquitectura Actual
- **Infraestructura:** Monorepo local con Docker Compose (PostgreSQL).
- **Backend:** Spring Boot (Java 17/21). Control de BBDD mediante Flyway. API documentada con Swagger.
- **Frontend:** React + Vite (Pendiente de desarrollo activo).

## Hitos Completados
- [x] **Fase 1:** Diseño de esquema SQL híbrido (Tablas base, override y vista de fusión).
- [x] **Fase 1:** Configuración de Flyway y esquemas iniciales (`V1__Initial_schema.sql`).
- [x] **Fase 2:** Mapeo de Entidades JPA (`PokemonBase`, `PokemonOverride`).
- [x] **Fase 2:** Mapeo de Entidad de solo lectura (`PokemonActive` - Vista).
- [x] **Fase 2:** Creación de repositorios Spring Data JPA para las tres entidades.

## Pendiente (Fase 3 y siguientes)
- [ ] **Fase 3 - Mejoras Aprobadas:** (Pendiente de definir por el usuario: DTOs, Paginación, Manejo de Excepciones).
- [ ] **Fase 3:** Desarrollo de Capa de Servicio (Lógica de negocio).
- [ ] **Fase 3:** Desarrollo de Controladores REST (Endpoints para la Pokédex).
- [ ] **Fase 4:** Lógica del Team Builder y Calculadora de Daño (Backend).
- [ ] **Fase 5:** Desarrollo del Frontend (React).
- [ ] **Fase 6:** Despliegue en VPS (Docker/Coolify).