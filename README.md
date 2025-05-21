# 🐣 Pokedex API 🐣

API para cadastro de Pokémons e seus Treinadores. Utiliza Spring Boot, MySQL, RabbitMQ e outras tecnologias modernas para comunicação e persistência de dados.

---
### 🚀 Subir os serviços.

Execute o seguinte comando na raiz do projeto:

```bash
docker-compose up -d 
```
### ⚙️ Tecnologias Utilizadas
<ul>
   <li>Java 21</li>
  <li>Spring Boot 3.4.x</li>
  <li>Spring Data JPA</li>
  <li>Spring Security</li>
  <li>MySQL</li>
  <li>RabbitMQ</li>
  <li>Swagger/OpenAPI</li>
  <li>Docker & Docker Compose</li>
  <li>Lombok</li>
</ul>  

### Acesse o Adminer (Banco de Dados)
```bash
URL: http://localhost:8080
Sistema: MySQL
Servidor: mysql-db
Usuário: pokemon_user
Senha: pokemon_pass
Banco de Dados: pokedex
```
### Acesse o painel do RabbitMQ
```bash
URL: http://localhost:15672
Usuário: admin
Senha: admin
```

### Acesse a documentação Swagger
```bash
http://localhost:8081/swagger-ui/index.html
```
### 

### 📁 Estrutura do Projeto
```bash
src/
└── main/
    ├── java/com/pokedex/
    │   ├── controller/
    │   ├── dto/
    │   ├── entity/
    │   ├── repository/
    │   ├── service/
    │   └── config/
    └── resources/
        ├── application.properties
        └── static/
```

### 📬 Exemplos de Requisição (Postman)
<p>Criar um Treinador</p>
<p>POST /treinadores</p>

```bash
{
  "nomeTreinador": "Ash Ketchum",
  "idade": 10,
  "idPokemon": 1
}
```
