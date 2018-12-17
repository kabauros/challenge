# Challenge
___

API Challenge - Desenvolvido com tecnologia Spring Boot / JDBC / H2 

Aplicação possui dois serviços:
	-  Acelerador de partículas
	-  Sistema de entregas
	
	
## Acelerador de Partículas

### Como funciona: 
O sistema irá processar a entrada levando em consideração:
 A = Número total de átomos
 N = Número máximo de átomos por região
 K = Número de Regiões

### Endpoint: 
- Acelerador de particulas 
	Efetuar com chamada POST para o enpoint "{host}/challenge/accelerator"
	com o seguinte body (JSON ) exemplo:
	{"input":"A N K"}
	
### Saída
A resposta consiste no número final de átomos em cada região (0...K-1). Ou seja, o primeiro número
representará os átomos da região 0, o segundo representará a quantidade de átomos na região 1 e assim
sucessivamente.

### Restrições
1 <= A <= 1000000000
1 <= N <= 100
1 <= K <= 100
___________________________________________________________________________________________________________

## Sistema de Entregas

### Como funciona: 
O serviço possui a funcionalidade de inserir uma rota e calcular a rota com o menor custo

### Repositório
Para consultar o banco de dados da aplicação deve iniciar a aplicação e acessar:
{host}/h2-console/
Garantir que o JDBC URL  = dbc:h2:mem:testdb
Irá abrir o console do H2 onde será possível consultar o banco de dados route
onde são inseridos as rotas iniciais e a novas rotas 
 

### Endpoints: 

- Inserir rotas 
	Efetuar com chamada POST para o enpoint "{host}/challenge/delivery/insert_route"
	com o seguinte body (JSON ) exemplo:
	{"origem":"A", 	"destino": "D", "distancia": 30 }

- Calcula rota de menor custo 
	Efetuar com chamada POST para o enpoint "{host}/challenge/delivery/calculete_route"
	com o seguinte body (JSON ) exemplo:
	{"origem":"A", "destino":"D", "autonomia":"10", "valor_do_litro":"2.50"}

