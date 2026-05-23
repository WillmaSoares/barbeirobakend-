# 💈 Barbearia Backend

API REST desenvolvida com Java Spring Boot para gerenciamento de uma barbearia.

## 🚀 Tecnologias

- Java 17
- Spring Boot 3.5
- Spring Security + JWT
- Spring Data JPA
- PostgreSQL
- Lombok

## 📋 Funcionalidades

- Cadastro de clientes, barbeiros e administradores
- Login e autenticação com JWT
- Agendamento de horários
- Cancelar e remarcar agendamentos
- Confirmar realização de serviço
- Histórico de atendimentos
- Agenda diária do barbeiro
- Relatório de faturamento
- CRUD de barbeiros e serviços

## 🔗 Endpoints principais

### Autenticação
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/auth/login` | Login |
| POST | `/auth/logout` | Logout |

### Usuários
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/users` | Cadastrar usuário |
| GET | `/users` | Listar usuários |
| GET | `/users/barbeiros` | Listar barbeiros |
| PUT | `/users/{id}` | Editar usuário |
| DELETE | `/users/{id}` | Remover usuário |

### Serviços
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/servicos` | Cadastrar serviço |
| GET | `/servicos` | Listar serviços |
| PUT | `/servicos/{id}` | Editar serviço |
| DELETE | `/servicos/{id}` | Remover serviço |

### Agendamentos
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/agendamentos` | Criar agendamento |
| GET | `/agendamentos` | Listar agendamentos |
| PATCH | `/agendamentos/{id}/cancelar` | Cancelar |
| PATCH | `/agendamentos/{id}/remarcar` | Remarcar |
| PATCH | `/agendamentos/{id}/concluir` | Concluir |
| GET | `/agendamentos/historico` | Histórico |
| GET | `/agendamentos/faturamento` | Faturamento |
| GET | `/agendamentos/barbeiro/{id}/data/{data}` | Agenda do dia |

## ⚙️ Como rodar

1. Clone o repositório
2. Configure o `application.properties` com seu banco PostgreSQL
3. Rode o projeto pelo IntelliJ ou com `mvn spring-boot:run`
4. A API estará disponível em `http://localhost:8080`

## 🔒 Autenticação

As rotas são protegidas por JWT. Para acessar envie o token no header:
```
Authorization: Bearer {token}
```