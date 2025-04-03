# Sistema de Geração de Cartões

## Descrição

Este projeto tem como objetivo principal gerar cartões para clientes com base em sua renda, utilizando uma arquitetura de microsserviços para garantir escalabilidade, flexibilidade e desempenho.

## Arquitetura do Projeto

O projeto é composto por vários microsserviços interligados, cada um com uma responsabilidade específica:

### 1. **eureka-server**

- **Função:** Service Discovery (registro e descoberta de serviços).
- **Descrição:** Centraliza o registro dos microsserviços, permitindo que eles se comuniquem dinamicamente.

### 2. **ms-cloud-gateway**

- **Função:** Gateway e Load Balancer.
- **Descrição:** Centraliza todas as requisições em uma única rota, distribuindo a carga entre os serviços disponíveis.
- **Segurança:** Implementa autenticação e autorização usando Spring Security e OAuth2.0.

### 3. **ms-customer**

- **Função:** Cadastro de usuários.
- **Descrição:** Responsável por gerenciar os dados dos clientes e disponibilizá-los para os demais serviços.

### 4. **ms-credit-rating**

- **Função:** Avaliação financeira do cliente.
- **Descrição:** Avalia a renda do cliente e envia uma solicitação de criação de cartão via **RabbitMQ** para o consumidor do serviço **ms-card**.

### 5. **ms-card**

- **Função:** Cadastro e geração de cartões.
- **Descrição:** Recebe as solicitações do **ms-credit-rating** e gera um cartão apropriado para o cliente.

---

## Tecnologias Utilizadas

O projeto foi desenvolvido com as seguintes tecnologias:

- **Java 21**
- **Spring Boot**
- **Eureka Server** — Service Discovery para registro e descoberta dos serviços.
- **Spring Cloud Gateway** — Roteamento e balanceamento de carga.
- **Docker** — Para criar e gerenciar os containers dos serviços.
- **RabbitMQ** — Implementação de fila para comunicação assíncrona entre os serviços.
- **Keycloak** — Autenticação e autorização centralizada.
- **Spring Security** — Segurança para o gateway.
- **OAuth2.0** — Controle de autenticação e autorização.
- **Spring Actuator** — Monitoramento e métricas para os microsserviços.
- **Spring Doc** — Documentação das aplicações.



