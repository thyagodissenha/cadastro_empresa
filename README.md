# Register

This is a project to demonstrate my skills in Java, Spring Boot and SQL.

Register is a REST API application that's can register and management individual and companies.
The category that can be placed are:
 - Costumer;
 - Supplier;
 - Employee;

Also can management:
 - Address;
 - Personal information;
 - Data documentation;

# Technologies

The project was design to use Java 17, Spring Boot 3.2 and PostgreSQL, everything inside of Docker technology.

# Features

 - API REST authenticated with Spring Security stateless session using JWT token;
 - Database using Docker technology;
 - Application using Docker technology;
 - DTOs implemented with Java records;
 - Database versioned with db migrations;
 - API REST documentation with Swagger;

## Prerequisites

 - Java 17 or later;
 - Docker;
 - Maven;

## Quick Start

 1. Clone the repository
 ```bash
 git clone <repository-url>
 ```
 2. Instance database with docker
  ```bash
 cd cadastro_empresa
 cd db
 docker compose up -d
 ```
 3. Instance application
 ```bash
 cd ..
 mvn clean install
 docker compose up --build -d
 ```
 4. Import postman collection from folder cadastro_empres\_postman
 5. Go to http://localhost:8081/api/helloworld and wait for answer
 ```bash
 Hello World
 ```
 6. API documentation at http://localhost:8081/api/swagger-ui/index.html