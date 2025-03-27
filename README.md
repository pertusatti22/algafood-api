# Algafood API

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

## Descrição
A **Algafood API** é um sistema backend desenvolvido em **Java Spring Boot**, projetado para gerenciar um sistema de delivery de alimentos, semelhante ao iFood. O sistema oferece funcionalidades para:
- **Cadastro de restaurantes, clientes e pedidos**
- **Gestão de cardápio e formas de pagamento**
- **Controle de status dos pedidos (Recebido, Em Preparo, Entregue, Cancelado)**
- **Autenticação e Autorização de Usuários**

## Tecnologias Utilizadas
- **Linguagem**: Java 17+
- **Framework**: Spring Boot 3.2.1
- **Banco de Dados**: PostgreSQL
- **ORM**: Hibernate / JPA
- **Migração de Banco**: Flyway
- **Validação**: Hibernate Validator
- **Testes**: JUnit, RestAssured
- **Segurança**: Spring Security com OAuth2 e JWT
- **Documentação**: OpenAPI/Swagger

## Como Rodar o Projeto
### 1. Clonar o Repositório
```bash
git clone https://github.com/seu-usuario/algafood-api.git
cd algafood-api
```
### 2. Configurar o Banco de Dados
Crie um banco de dados PostgreSQL e configure as credenciais no arquivo `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/algafood_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

### 3. Executar a API
```bash
mvn spring-boot:run
```

### 4. Acessar a Documentação Swagger
```
http://localhost:8080/swagger-ui.html
```

## Estrutura do Projeto
```
algafood-api/
├── src/main/java/com/algafood/api
│   ├── controller/    # Controllers REST
│   ├── service/       # Regras de negócio
│   ├── repository/    # Camada de acesso ao banco
│   ├── model/         # Entidades JPA
│   ├── dto/           # Data Transfer Objects
├── src/test/java/com/algafood/api  # Testes de integração
├── pom.xml  # Configuração do Maven
```

## Rotas da API (Exemplo)
### Criar Restaurante
```http
POST /api/restaurantes
```
Corpo:
```json
{
  "nome": "Pizzaria do João",
  "taxaFrete": 5.99,
  "cozinhaId": 1
}
```

### Criar Pedido
```http
POST /api/pedidos
```
Corpo:
```json
{
  "clienteId": 1,
  "restauranteId": 2,
  "itens": [
    { "produtoId": 10, "quantidade": 2 }
  ],
  "formaPagamentoId": 3
}

**Desenvolvido durante o curso Especialista Spring REST da Algaworkz por [pertusatti22](https://github.com/pertusatti22)** 🚀

