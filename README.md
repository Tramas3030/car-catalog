
## Propósito do projeto

## Autor

- Matheus Raphael Trindade Guedes

## Funcionalidades

- Cadastro de clientes
- Autenticação de clientes
- Cadastro de empresas
- Autenticação de empresas
- Cadastro de carros

### Stack utilizada

- Linguagem: Java
- Framework: Spring Boot (Web, Jpa, Security)
- Banco de Dados: PostgreSQL
- Maven
- Spring Validation
- Java JWT

## Diagrama de classes

## Configuração e execução

Pré-requisitos:
- Java 17
- Docker

Como o deploy da aplicação ainda não foi feita, no momento só é possível acessar rodando ela localmente. Caso deseje, execute os seguintes passos:

    1. Clone o repositório.
    2. Instale as dependências do arquivo pom.xml com o Maven.
    3. Rode o comando no terminal: docker-compose up -d
    4. Execute o CarCatalogApplication.Java




## Documentação da API

#### Criar um cliente

```http
  POST localhost:8080/client/
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `name` | `string` | **Obrigatório**. O nome do cliente |
| `username`  | `string` | **Obrigatório**. O nome de usuário do cliente |
| `email` | `string` | **Obrigatório**. O email do cliente |
| `password` | `string` | **Obrigatório**. A senha do cliente |



#### Autenticação de um cliente

```http
  POST localhost:8080/auth/client
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `username`      | `string` | **Obrigatório**. O nome de usuário do cliente que deseja autenticar |
| `password`      | `string` | **Obrigatório**. A senha do cliente que deseja autenticar |


#### Obter as informações cadastradas de um cliente

```http
  GET localhost:8080/client/
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `Authorization`      | `Header` | **Obrigatório**. Bearer token para autenticação. Deve ser incluído no cabeçalho da requisição no formato "Bearer {token}". O token será obtido ao fazer a autenticação de um cliente |

#### Criar uma empresa

```http
  POST localhost:8080/company/
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `name` | `string` | **Obrigatório**. O nome da empresa |
| `address`  | `string` | **Obrigatório**. O endereço da empresa |
| `email` | `string` | **Obrigatório**. O email da empresa |
| `password` | `string` | **Obrigatório**. A senha da empresa |
| `website` | `string` | O link do website da empresa |
| `description` | `string` | Descrição da empresa |

#### Autenticação de uma empresa

```http
  POST localhost:8080/auth/company
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `name`      | `string` | **Obrigatório**. O nome do cliente que deseja autenticar |
| `password`      | `string` | **Obrigatório**. A senha da empresa que deseja autenticar |

#### Obter as informações cadastradas de uma empresa

```http
  GET localhost:8080/company/
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `Authorization`      | `Header` | **Obrigatório**. Bearer token para autenticação. Deve ser incluído no cabeçalho da requisição no formato "Bearer {token}". O token será obtido ao fazer a autenticação de uma empresa |