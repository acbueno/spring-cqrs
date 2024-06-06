# Spring CQRS Example

Este projeto é um exemplo de implementação do padrão CQRS (Command Query Responsibility Segregation) com Spring Boot e MongoDB. O objetivo é demonstrar como aplicar este padrão em uma aplicação real, utilizando eventos para sincronização e processamento assíncrono.

## O que é CQRS?

CQRS, ou Command Query Responsibility Segregation, é um padrão de design arquitetônico que separa a leitura (queries) e a escrita (commands) de dados em sistemas de software. A principal vantagem do CQRS é permitir que cada lado (leitura e escrita) seja escalado, otimizado e evoluído independentemente. 

- **Commands**: Responsáveis por realizar operações que modificam o estado da aplicação.
- **Queries**: Responsáveis por realizar operações de leitura e retornar dados.

## Pré-requisitos

Antes de começar, você precisará ter as seguintes ferramentas instaladas:

- [Java 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven 3.6.3+](https://maven.apache.org/download.cgi)
- [Docker](https://www.docker.com/products/docker-desktop)

## Configuração do Ambiente

### 1. Clone o Repositório

```bash
git clone https://github.com/acbueno/spring-cqrs.git
cd spring-cqrs
```
## 2. Configurar o MongoDB com Docker
Inicie uma instância do MongoDB usando Docker:
```bash
docker run --name mongo -d -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=usuario -e MONGO_INITDB_ROOT_PASSWORD=senha mongo
```
## 3. Configuração do Application Properties
No diretório src/main/resources, edite o arquivo application.properties para incluir as credenciais do MongoDB:
```properties
spring.data.mongodb.uri=mongodb://usuario:senha@localhost:27017/suaBaseDeDados
```
## Estrutura do Projeto
O projeto está estruturado da seguinte forma:

- **Comandos:** Definição e manipulação de comandos.
- **Consultas:** Definição e execução de consultas.
- **Eventos:** Definição e publicação de eventos.
- **Modelos:** Definição das entidades do domínio.
- **Repositórios:** Interface para acesso a dados no MongoDB.
- **Serviços:** Lógica de negócios.

## Executando a Aplicação
Para executar a aplicação, utilize o Maven:
```bash
mvn spring-boot:run
```
A aplicação estará disponível em http://localhost:8080.

## Acessando via Open API
http://localhost:8080/swagger-ui/index.html

## Uso de Eventos
O projeto utiliza o ApplicationEventPublisher do Spring para publicar eventos que representam ações realizadas no sistema, como a criação de um novo item (livro, CD ou revista). Esses eventos permitem que outras partes do sistema reajam a essas ações de maneira desacoplada e assíncrona.
