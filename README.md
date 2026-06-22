# Pokémon Champions Tools ⚔️

Plataforma web avanzada diseñada para el ecosistema de *Pokémon Champions*. Incluye herramientas competitivas como una Pokédex/Megadex, un Team Builder adaptado y una Calculadora de Daño avanzada.

## 🛠️ Stack Tecnológico

* **Frontend:** React (Vite) + Tailwind CSS
* **Backend:** Java 17+ con Spring Boot 3
* **Base de Datos:** PostgreSQL
* **Infraestructura:** Docker (Entorno local)

## 🚀 Cómo levantar el entorno de desarrollo

Este proyecto utiliza un enfoque de monorepo. Sigue estos pasos para arrancar todos los servicios en tu máquina local.

### 1. Base de Datos (Docker)
Levanta la instancia de PostgreSQL utilizando el archivo de orquestación incluido:
\`\`\`bash
docker-compose up -d
\`\`\`

### 2. Backend (Spring Boot)
Navega a la carpeta del backend y arranca el servidor:
\`\`\`bash
cd backend
./mvnw spring-boot:run
\`\`\`
*La API estará disponible en `http://localhost:8080`*

### 3. Frontend (React)
Abre una nueva terminal, navega al frontend y levanta el entorno de Vite:
\`\`\`bash
cd frontend
npm install
npm run dev
\`\`\`
*La interfaz web estará disponible en el puerto que indique Vite (generalmente `http://localhost:5173`)*