# Bank System API

Olá, pessoal! Esta é uma aplicação de exemplo que fiz para estudos onde há uma implementação de uma API de serviços bancários utilizando **Spring Boot**, **Spring Security** com autenticação JWT e banco de dados **MySQL**.
Nesta aplicação apliquei alguns conhecimentos sobre o desenvolvimento web na parte do servidor usando o Java, que é uma ferramenta muito poderosa.

## Funcionalidades

- **Autenticação e Autorização**: Gerenciamento de usuários com autenticação via JWT.
- **Gerenciamento de Contas Bancárias**: Criação e consulta de contas bancárias.
- **Transações Bancárias**: Depósitos, saques e transferências entre contas.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Security**
- **JWT (JSON Web Tokens)**
- **MySQL**
- **Maven**

## Endpoints Principais

### Autenticação

- **POST /api/auth/login**: Autentica o usuário e retorna um token JWT.
- **POST /auth/register**: Cria um novo usuário.

### Usuários


- **GET /users/listAll**: Retorna a lista de usuários (requer autenticação).
- **GET /users/findOne{id}**: Consulta os dados de um usuário (requer autenticação).
- **PUT /users/updateUser{id}**: Atualiza os dados de um usuário (requer autenticação).
- **DELETE /users/deleteUser/{id}**: Remove um usuário (requer autenticação).

### Contas Bancárias

- **GET /accounts/showAccount/{id}**: Retorna os detalhes de uma conta (requer autenticação).
- **GET /accounts/showCard/{id}**: Retorna os detalhes de um cartão (requer autenticação).


### Transações

- **POST /account/deposit/{id}**: Realiza um depósito.
- **POST /account/withDraw/{id}**: Realiza um saque.

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
