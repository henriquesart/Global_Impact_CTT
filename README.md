
# zeroWaste

- Vídeo de apresentação:
```bash

```
#
`Autores`

- 86062 - Leonardo Andrade Antunes de Bem

- 85521 - Martin david Valdes Olcese

- 82172 - Henrique Sartal Santos

- 85744 - João Carlos Melo Azevedo

- 84314 - Iago Manholetti Alexandrino

- 85569 - Gustavo Gonçalves de Araujo

## Endpoints API

#### Gerenciar Usuários

| Função | Endpoint    | Verbo                      | Método   |
| :- | :- | :- | :- |
| Listar todos os usuários                 | `api/user` | GET | `index()` |
| Exibir detalhes de um usuário específico | `api/user/{id}` | GET | `get()` |
| Cadastrar um usuário                     | `api/user` | POST | `create()` |
| Apagar um usuário                        | `api/user/{id}` | DELETE | `delete()` |
| Alterar dados de usuário                 | `api/user/{id}` | UPDATE | `update()` |

#### Gerenciar Condomínios

| Função | Endpoint    | Verbo                      | Método   |
| :- | :- | :- | :- |
| Listar todos os condomínio               | `api/address` | GET | `index()` |
| Exibir detalhes de um condomínio específico | `api/address/{id}` | GET | `get()` |
| Cadastrar um condomínio                     | `api/address` | POST | `create()` |
| Apagar um condomínio                        | `api/address/{id}` | DELETE | `delete()` |
| Alterar dados do condomínio                 | `api/address/{id}` | UPDATE | `update()` |



  
## Funcionalidades do backend

| Cadastro | Listagem   |
| :- | :- |
| Usuários                 | Usuários |
| Condomínios | Condomínios |

` Os endpoints dão a possibilidade do gerenciamento total dos objetos`

## Arquitetura do projeto

- Aplicação web na arquitetura MVC

- Desenvolvido com Spring Framework

- Thymeleaf (Front-end)

- Lombok

- BeanValidation

- Spring Data JPA (H2)
## Iniciar o projeto

1- Clone o projeto.

```bash
  git clone https://github.com/henriquesart/Global_Impact_CTT
```
2 - Selecione o arquivo "ZerowasteApplication.java" e rode como uma aplicação java.

3 - Entre no projeto via navegador pelo endereço "http://localhost:8080/"

  