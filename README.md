
## Propósito do projeto
O objetivo deste projeto é desenvolver uma API 
para um website de catálogo de carros, cujo 
objetivo é facilitar a divulgação de 
empresas especializadas no setor automotivo, 
como revendas, trocas de veículos e 
negócios focados em carros antigos. 
A API visa conectar essas empresas com 
potenciais clientes, permitindo que 
encontrem com mais facilidade os 
serviços e produtos oferecidos, 
promovendo assim um ambiente de 
maior visibilidade e acessibilidade 
no mercado automotivo.
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

O diagrama de classes da aplicação se encontra nesse link: [Diagrama de classes](https://www.planttext.com/api/plantuml/svg/nLVRRjiu47tNL-ZHGTn-GH3KjTtMksrJvDB5eYW2bfmutAL8BKabDOh-UocHadcJOnjPr2-Mo9apXtEbNYcDf6ugLc26b2hdIBuH3IVBxnXgJGKlVnIb-Pqc6vEJucVHQucgHdmpefdRzBLl58mOJNTylQMKGdu0fT0Q5jSNJkd5bPQKhylARWHhTnGOiT2HyYJKcfQ-Xc-p9_8ESS90pWNNKZ3pr9jtc5UYaHXwFFlcB8z2J7RedbZbIr2ru0gMN5EzENjFbJwBZd9-Njvto1z0tmioa-kc0gu_2lqPCUgvyedz4hnppnfzFsVKo5t2VmqedJgyCS7Yg0ezNXlbHo6TqtCeaqXzS7slEiB2-Y6bWJ0shhZLub_WTkEzCClmlQOIr2tbAPK1QfB1c9QHliVdanHtbC5Jb1AlP5q55QBChjpSh1ObTKuRCpBnq0Ud9LxiKAUbG_HhjiEpUTJpzUqUJJuNUHC3ZDW2QRYc5PHOWdaaCntJkOHQAAg5x2cTNdIvYDYPp_VSr2KdhpStZig5NBRsHrEfOtTo062CbCr18pn72g9WAp2dqt_2ngucvyBHWXNxvBorv5WGqqpgy7r7pfhC1Dnec6HB56KM_IJe0f4zpdCI3tAjvniiOkzbhC2E8ZXQFWCFb_HM80wqdLrxb7IcqGswsKeTQszMwtdwMu9rQ8Dp-O7a7Xx0WWaPh11GMDAktiBHR3A3_GqebAuGR-uGreqqQREz7DJaDpCmje_eai_APMiMsv2kzcwhLlw80o12J3geWxgyMto4RwO2OVVfdwQEvAvnq4UbRzqVpG5cdCnRltV_pb7PukkYuwQYS-bjEnqx6zsbAiAVCVPwiyKCOv5CbfZRYWICdFz3-okINgXtdTyFhE-3Q1RkCGV7a7o8N4-8-t4GB-o_3PyGyGWOLd3_b1goz69ZYODml7B8V0ggP60Nh6B_pMEv00P7kUD1K18E8IEqsfKLRq4RL3Kaug4MkyIEGTelXeX6nlGVVrtR0Md6wGCbsy-TxAtdT06jTudHAX_QZugspDjPqwTKDtX2-Fy7-CgSIvg0MV9lADDR2-cP_ddKuOeNAIAizehhzax89k-qhgz0FfZmkxjLAUt_j0psxFGrc_PXMbgW-JsYt9JRy9oXdH3sgVvkaYQDvaWZ9jQpkcOK8__JtNIQFYXVlfP8hbMdcRsaldnvdl-qAzBBTYpRW-mXkeKDhfwjM7oNB78NuwsWrIoojzD4AcmZtNRIgfAUsedrFR78Ta8FoOabhIX46MiVeLIsObgHf5oAA4kTqB3z2ZXfAlOB)

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

#### Criar um carro

```http
  POST localhost:8080/car/
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `name` | `string` | **Obrigatório**. O nome do carro |
| `color`  | `string` | **Obrigatório**. A cor do carro |
| `description` | `string` | **Obrigatório**. A descrição do carro |
| `modelYear` | `string` | **Obrigatório**. O ano modelo do carro |
| `manufacturer` | `string` | **Obrigatório**. A fabricante do carro |
| `Authorization`      | `Header` | **Obrigatório**. Bearer token para autenticação. Deve ser incluído no cabeçalho da requisição no formato "Bearer {token}". O token será obtido ao fazer a autenticação de uma empresa |