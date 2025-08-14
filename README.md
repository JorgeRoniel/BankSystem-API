# Bank System API

Olá, pessoal! Esta é uma aplicação de exemplo que fiz para estudos onde há uma implementação de uma API de serviços bancários utilizando **Spring Boot**, **Spring Security** com autenticação JWT e banco de dados **MySQL**.
Nesta aplicação apliquei alguns conhecimentos sobre o desenvolvimento web na parte do servidor usando o Java, que é uma ferramenta muito poderosa.

## Funcionalidades

- **Autenticação e Autorização**: Gerenciamento de usuários com autenticação via JWT.
- **Gerenciamento de Contas Bancárias**: Criação e consulta de contas bancárias.
- **Transações Bancárias**: Depósitos e saques

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Security**
- **JWT (JSON Web Tokens)**
- **MySQL**
- **Maven**

## Endpoints Principais

### Autenticação

- **POST /auth/login** — Login de usuário (retorna um token JWT)
- **POST /auth/register** — Cadastro de usuário

### Usuários


- **GET /users/listAll** — Lista todos os usuários (ADMIN)
- **GET /users/{id}** — Busca usuário por ID (ADMIN)
- **PUT /users/{id}/update** — Atualiza usuário (ADMIN)
- **DELETE /users/{id}/delete** — Remove usuário (ADMIN)

### Contas Bancárias

- **POST /account/{id}/deposit**: Deposita valor na conta.
- **POST /account/{id}/withdraw**: Saque na conta.
- **GET /account/{id}**: Consulta dados da conta.
- **GET /account/card/{id}**: Consulta dados do cartão.

## Segurança

- A aplicação utiliza **JWT** para autenticação e autorização.
- O token deve ser incluído no cabeçalho das requisições protegidas:
  ```http
  Authorization: Bearer <TOKEN>
  ```

## Testes

Recomenda-se o uso do **Postman**.

## Estrutura do Projeto

```plaintext
src/
├── main/
│   ├── java/me/shrk/BankAccountAplication
│   │   ├── segurity     # Configurações do Spring Security
│   │   ├── controllers # Controladores REST
|   |   ├── exceptions # Custom Exceptions
|   |   ├── infra      # Advice Controler
│   │   ├── models      # Modelos de dados
│   │   ├── repositories # Repositórios JPA
│   │   ├── services    # Regras de negócio
│   │   └── dtos       # data transfer objects
│   └── resources/
│       ├── application.properties # Configurações da aplicação
│       └── static/                # Arquivos estáticos (se aplicável)
└── test/
    └── java/com/example/BankAccountAplication   # Testes unitários e de integração
```
