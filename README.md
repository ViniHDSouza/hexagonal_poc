
# POC - Arquitetura Hexagonal com Java 17 + Spring Boot 3 + MySQL + Docker

## Estrutura do Projeto

```
product-hexagonal
├── adapter
│   ├── in
│   │   └── web
│   │       └── ProductController.java
│   └── out
│       └── persistence
│           ├── ProductEntity.java
│           ├── ProductJpaRepository.java
│           └── ProductPersistenceAdapter.java
├── application
│   └── ProductService.java
├── domain
│   ├── Product.java
│   └── ProductRepository.java
├── config
│   └── SwaggerConfig.java
├── Dockerfile
├── docker-compose.yml
├── pom.xml
├── src/main/resources/application.properties
└── ProductHexagonalApplication.java
```

## Arquitetura Hexagonal

A Arquitetura Hexagonal (Ports & Adapters) separa a lógica de negócio das implementações técnicas.

- **Core (Domínio)**: Regras de negócio (`Product` e `ProductRepository`).
- **Portas**: Interfaces de comunicação.
  - Entrada: `ProductController` (REST).
  - Saída: `ProductPersistenceAdapter` (JPA).
- **Adapters**: Implementações das portas.

## Como executar com Docker

Pré-requisitos:
- Docker e Docker Compose.

### 1. Build da aplicação

```bash
./mvnw clean package
```

### 2. Subir com Docker Compose

```bash
docker-compose up --build
```

### 3. Acessar

- Aplicação: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui.html
- Banco MySQL:
  - Host: localhost
  - Porta: 3306
  - Usuário: root
  - Senha: root
  - Banco: productdb

## Endpoints principais

- GET `/products`
- POST `/products`
- PUT `/products/{id}`
- DELETE `/products/{id}`

## Tecnologias

- Java 17
- Spring Boot 3.x
- MySQL 8
- Docker
- Spring Data JPA
- Swagger OpenAPI

## ASCII POC HEXAGONAL

```
██████╗  ██████╗  ██████╗       ██╗  ██╗███████╗██╗  ██╗ ██████╗  █████╗ ███╗   ██╗ ██████╗  █████╗ ██╗     
██╔══██╗██╔═══██╗██╔════╝       ██║  ██║██╔════╝██║  ██║██╔════╝ ██╔══██╗████╗  ██║██╔════╝ ██╔══██╗██║     
██████╔╝██║   ██║██║  ███╗      ███████║█████╗  ███████║██║  ███╗███████║██╔██╗ ██║██║  ███╗███████║██║     
██╔═══╝ ██║   ██║██║   ██║      ██╔══██║██╔══╝  ██╔══██║██║   ██║██╔══██║██║╚██╗██║██║   ██║██╔══██║██║     
██║     ╚██████╔╝╚██████╔╝      ██║  ██║███████╗██║  ██║╚██████╔╝██║  ██║██║ ╚████║╚██████╔╝██║  ██║███████╗
╚═╝      ╚═════╝  ╚═════╝       ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝  ╚═╝╚══════╝
```
