
<h1 align="center">
  Ze-Code-Challenge 🍻🍺
</h1>

API para gerenciar parceiros a partir de geolocalização[desse desafio](https://github.com/ZXVentures/ze-code-challenges/blob/master/backend.md).

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data Mongo](https://spring.io/projects/spring-data-mongodb)


## Práticas adotadas

- SOLID
- Arquitetura Limpa
- Armazenamento em geoJSON
- Cálculo de geolocalização a partir de latitude e longtide
- Testes automatizados
- Query Personalizada
- Uso de DTOs para a API
- Injeção de Dependências



## Como Executar

### Localmente
- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Executar:
```
java -jar ze-code-challenge/target/ze-code-challenge-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).

### Usando Docker

- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Construir a imagem:
```
./mvnw spring-boot:build-image
```
- Executar o container:
```
docker run --name ze-code-challenge -p 8080:8080  -d ze-code-challenge:0.0.1-SNAPSHOT
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [Insomnia](https://insomnia.rest/download):

- POST /partner
```
[
       {
          "id": "1",
          "tradingName": "Adega Osasco",
          "ownerName": "Ze da Ambev",
          "document": "02.453.716/000170",
          "coverageArea": {
             "type": "MultiPolygon",
             "coordinates": [
                [
                   [
                      [
                         -43.36556,
                         -22.99669
                      ],
                      [
                         -43.36539,
                         -23.01928
                      ],
                      [
                         -43.26583,
                         -23.01802
                      ],
                      [
                         -43.25724,
                         -23.00649
                      ],
                      [
                         -43.23355,
                         -23.00127
                      ],
                      [
                         -43.2381,
                         -22.99716
                      ],
                      [
                         -43.23866,
                         -22.99649
                      ],
                      [
                         -43.24063,
                         -22.99756
                      ],
                      [
                         -43.24634,
                         -22.99736
                      ],
                      [
                         -43.24677,
                         -22.99606
                      ],
                      [
                         -43.24067,
                         -22.99381
                      ],
                      [
                         -43.24886,
                         -22.99121
                      ],
                      [
                         -43.25617,
                         -22.99456
                      ],
                      [
                         -43.25625,
                         -22.99203
                      ],
                      [
                         -43.25346,
                         -22.99065
                      ],
                      [
                         -43.29599,
                         -22.98283
                      ],
                      [
                         -43.3262,
                         -22.96481
                      ],
                      [
                         -43.33427,
                         -22.96402
                      ],
                      [
                         -43.33616,
                         -22.96829
                      ],
                      [
                         -43.342,
                         -22.98157
                      ],
                      [
                         -43.34817,
                         -22.97967
                      ],
                      [
                         -43.35142,
                         -22.98062
                      ],
                      [
                         -43.3573,
                         -22.98084
                      ],
                      [
                         -43.36522,
                         -22.98032
                      ],
                      [
                         -43.36696,
                         -22.98422
                      ],
                      [
                         -43.36717,
                         -22.98855
                      ],
                      [
                         -43.36636,
                         -22.99351
                      ],
                      [
                         -43.36556,
                         -22.99669
                      ]
                   ]
                ]
             ]
          },
          "address": {
             "type": "Point",
             "coordinates": [
                -43.297337,
                -23.013538
             ]
          }
       }
]
```

- GET /partner/proxim
```
{
	"lat": -43.297337,
	"lon": -23.013538
}

```
- GET /partner/{id}
```
{
  "id": 1, 
  "tradingName": "Adega da Cerveja - Pinheiros",
  "ownerName": "Zé da Silva",
  "document": "1432132123891/0001",
  "coverageArea": { 
    "type": "MultiPolygon", 
    "coordinates": [
      [[[30, 20], [45, 40], [10, 40], [30, 20]]], 
      [[[15, 5], [40, 10], [10, 20], [5, 10], [15, 5]]]
    ]
  },
  "address": { 
    "type": "Point",
    "coordinates": [-46.57421, -21.785741]
  }
}

```


