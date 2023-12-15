# Aluguel de Carros

Esta é uma API REST que oferece operações CRUD (Create, Read, Update, Delete) para gerenciar informações de um sistema de aluguel de carros. A aplicação foi desenvolvida em Java 17 usando o framework Spring Boot e utiliza o banco de dados MySQL para armazenamento.

## Endpoints

### Obtem uma Lista de Carros

**Endpoint:**
GET /carros

**Descrição:**
Retorna uma lista de todos os carros cadastrados.

### Obtem os Dados do Carro por ID

**Endpoint:**
GET /carros/{id}

**Parâmetros:**
- `{id}`: Identificador único do carro.

**Descrição:**
Retorna os dados do carro correspondente ao ID fornecido.

### Obtem uma Lista de Clientes

**Endpoint:**
GET /clientes

**Descrição:**
Retorna uma lista de todos os clientes cadastrados.

### Obtem Dados do Cliente por ID

**Endpoint:**
GET /clientes/{id}

**Parâmetros:**
- `{id}`: Identificador único do cliente.

**Descrição:**
Retorna os dados do cliente correspondente ao ID fornecido.

### Obtem uma Lista de Alugueis

**Endpoint:**
GET /alugueis

**Descrição:**
Retorna uma lista de todos os alugueis cadastrados.

### Obtem os Dados do Aluguel por ID

**Endpoint:**
GET /alugueis/{id}

**Parâmetros:**
- `{id}`: Identificador único do aluguel.

**Descrição:**
Retorna os dados do aluguel correspondente ao ID fornecido.

### Adiciona um Novo Carro

**Endpoint:**
POST /carros

**Corpo da Requisição (JSON):**
```json
{
	"model": "Uno",
	"color": "Azul",
	"year": 2002,
	"place": "BRA0S1L",
	"pricePerDay": 63.3
}
```

**Descrição:**
Adiciona um novo carro com os detalhes fornecidos no corpo da requisição.

### Adiciona um Novo Cliente

**Endpoint:**
POST /clientes

**Corpo da Requisição (JSON):**
```json
{
	"name": "Tilapia Junior",
	"cpf": "123.123.123-32",
	"telefone": "(35) 99999 9999"
}
```

**Descrição:**
Adiciona um novo cliente com os detalhes fornecidos no corpo da requisição.

### Adiciona um Novo Aluguel

**Endpoint:**
POST /alugueis

**Corpo da Requisição (JSON):**
```json
{
	"car":{
		"id": 1,
		"model": "Uno",
		"color": "Azul",
		"year": 2002,
		"place": "BRA0S1L",
		"pricePerDay": 63.3
	},
	"client": {
		"id": 1,
		"name": "Tilapia Junior",
    "cpf": "123.123.123-32",
    "telefone": "(35) 99999 9999"
	},
	"startDate": "2023-12-10",
	"endDate": "2023-12-15"
}
```

**Descrição:**
Adiciona um novo aluguel com os detalhes fornecidos no corpo da requisição.

### Edita os dados do carro

**Endpoint:**
PUT /carros/{id}

**Parâmetros:**
- `{id}`: Identificador único do carro.

**Corpo da Requisição (JSON):**
```json
{
	"model": "Uno",
	"color": "Vermelho",
	"year": 2002,
	"place": "BRA0S1L",
	"pricePerDay": 63.3
}
```

**Descrição:**
Modifica os dados do carro correspondente ao ID fornecido com os detalhes fornecidos no corpo da requisição.

### Edita os dados do cliente

**Endpoint:**
PUT /clientes/{id}

**Parâmetros:**
- `{id}`: Identificador único do cliente.

**Corpo da Requisição (JSON):**
```json
{
	"name": "Tilapia Junior",
	"cpf": "123.123.123-32",
	"telefone": "(35) 98888 9999"
}
```

**Descrição:**
Modifica os dados do cliente correspondente ao ID fornecido com os detalhes fornecidos no corpo da requisição.

### Edita os dados do aluguel

**Endpoint:**
PUT /alugueis/{id}

**Parâmetros:**
- `{id}`: Identificador único do aluguel.

**Corpo da Requisição (JSON):**
```json
{
	"car":{
		"id": 1,
		"model": "Uno",
		"color": "Azul",
		"year": 2002,
		"place": "BRA0S1L",
		"pricePerDay": 63.3
	},
	"client": {
		"id": 1,
		"name": "Tilapia Junior",
    "cpf": "123.123.123-32",
    "telefone": "(35) 99999 9999"
	},
	"startDate": "2023-12-10",
	"endDate": "2023-12-30"
}
```

**Descrição:**
Modifica os dados do aluguel correspondente ao ID fornecido com os detalhes fornecidos no corpo da requisição.

### Deleta todos os clientes

**Endpoint:**
DELETE /clientes/

**Descrição:**
Remove todos os clientes cadastrados no banco de dados.

### Deleta um cliente por ID

**Endpoint:**
DELETE /clientes/{id}

**Parâmetros:**
- `{id}`: Identificador único da cliente.

**Descrição:**
Remove o cliente correspondente ao ID fornecido.

### Deleta todos os carros

**Endpoint:**
DELETE /carros/

**Descrição:**
Remove todos os carros cadastrados no banco de dados.

### Deleta um carro por ID

**Endpoint:**
DELETE /carros/{id}

**Parâmetros:**
- `{id}`: Identificador único da carro.

**Descrição:**
Remove o carro correspondente ao ID fornecido.

### Deleta todos alugueis

**Endpoint:**
DELETE /alugueis/

**Descrição:**
Remove todos os alugueis cadastrados no banco de dados.

### Deleta um aluguel por ID

**Endpoint:**
DELETE /alugueis/{id}

**Parâmetros:**
- `{id}`: Identificador único da aluguel.

**Descrição:**
Remove a aluguel correspondente ao ID fornecido.

## Configuração do Banco de Dados
A aplicação utiliza o banco de dados MySQL. Você vai precisar configurar o arquivo **application.properties**, vai ser encontrado em ./src/main/resources.
```
spring.datasource.url=jdbc:mysql://localhost:3306/${banco_de_dados}
spring.datasource.username=${usuario}
spring.datasource.password=${senha}

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```
- ${banco_de_dados}: Altera para o nome do seu banco de dados.
- ${usuario}: Altera para o nome do seu usuario.
- ${senha}: Altera para a senha do seu banco de dados.

## Execução da Aplicação

``` ./mvnw spring-boot:run ```

Obs: Certifique-se de ter o Java e o Maven instalados em seu ambiente antes de executar a aplicação.
