API REST com Java e Spring Boot, Ada.

Requisitos
IDE IntelliJ
Maven
Recomendações

Localhost
A API roda na porta 8080, caso ela esteja ocupada, basta entrar no arquivo application.properties nas pasta resources e atribuir um novo valor na linha que contem server.port=NOVO VALOR

Postman (Utilizado)
Testa serviços RESTful (Web APIs) por meio do envio de requisições HTTP
Arquivo: TestesStarWarsResistence.postman_collection.json

Endpoints
Adicionar rebelde
Um rebelde é adicionado juntamente com sua localização e seu inventário.
Cada item do inventário tem uma pontuação fixa, a qual é multiplicada automaticamente pela quantidade do mesmo item. Segue a lista de itens disponíveis:
Item	Pontos
1 Arma	4 Pontos
1 Munição	3 Pontos
1 Água	2 Pontos
1 Comida	1 Pontos
Os itens que não contém nesta lista ou estão escritos de forma diferente são cadastrados automaticamente como Lixo com sua quantidade e seus pontos zerados.
OBS: Seus itens devem ser declarados quando o rebelde se cadastradar no sistema. Após isso seu inventário só poderá mudar através de negociação com outros rebeldes.

Método POST: localhost:8080/rebelde

{
    "nome" : "Jhon",
    "idade" : 24,
    "genero" : "M",
    "traidor" : false,
    "localizacao" : {
        "latitude" : "-9.939201930",
        "longitude" : "-10.2084810",
        "galaxia" : "Andromeda"
    },
    "base": "Endurace"
    "inventario" : {
        "itens" : [
            {
                "nome" : "Arma",
                "qtd" : 1
            },
            {
                "nome" : "Munição",
                "qtd" : 0
            },
            {
                "nome" : "Água",
                "qtd" : 5
            },
            {
                "nome" : "Comida",
                "qtd" : 3
            }
        ]	
    }
}
Atualizar localização do rebelde
Um rebelde possuir a capacidade de reportar sua última localização, armazenando a nova latitude, longitude, galaxia.
Na URL é passado o id do rebelde como seu identificador.

Método PUT: localhost:8080/localizacao/reportar/id
{
    "latitude" : "-7.43243",
    "longitude" : "-39.29113",
    "galaxia" : "Via Láctea"
}
Buscar rebelde
Retorna todas as informações referentes a um rebelde especifico.

Na URL é passado como parâmetro o número correspondente ao id do rebelde.
Método GET: localhost:8080/rebelde?id=id
{
    "id": 1,
    "nome": "Jhon",
    "idade": 24,
    "genero": "M",
    "traidor" : false,
    "localizacao" : {
        "latitude" : "-7.43243",
        "longitude" : "-39.29113",
        "galaxia" : "Via Láctea"
    },
    "base": "Endurace"
    "inventario": {
        "id": 1,
        "itens": [
            {
                "id": 1,
                "nome": "Arma",
                "qtd": 1,
                "pontos": 4
            },
            {
                "id": 2,
                "nome": "Munição",
                "qtd": 0,
                "pontos": 6
            },
            {
                "id": 3,
                "nome": "Água",
                "qtd": 5,
                "pontos": 10
            },
            {
                "id": 4,
                "nome": "Comida",
                "qtd": 3,
                "pontos": 3
            }
        ]
    }
}
Negociar itens
Os rebeldes poderão negociar itens entre eles. Para isso, eles devem respeitar a tabela de preços citada acima, onde o valor do item é descrito em termo de pontos.
Ambos os lados deverão oferecer a mesma quantidade de pontos. Por exemplo, 1 munição e 1 comida (1 x 3 + 1 x 1) valem 2 águas (2 x 2) ou 4 comidas (4 x 1).

Caso os nomes dos itens estejam diferente da tebela de preços, a quantidade de itens seja maior que o inventário do rebelde ou a pontuação não bata o trade será CANCELADO

OBS: A negociação em si não será armazenada, mas os itens deverão ser transferidos de um rebelde a outro.
Método POST: localhost:8080/rebelde/negociacao
[
    {
        "idRebelde" : 1,
        "itens" : [
            {
                "nome": "Munição",
                "qtd": 1
            },
            {
                "nome": "Comida",
                "qtd": 1
            }
        ]
    },
    {
        "idRebelde" : 8,
        "itens" : [
            {
                "nome": "Água",
                "qtd": 2
            }
        ]
    }
]
Reportar o rebelde como um traidor
Um rebelde é marcado como traidor quando, ao menos, três outros rebeldes reportarem a traição.
Uma vez marcado como traidor, os itens do inventário se tornam inacessíveis (eles não podem ser negociados com os demais).
Um traidor não pode negociar os recursos com os demais rebeldes, não pode manipular seu inventário, nem ser exibido em relatórios.

Método POST: localhost:8080/reporte
{
    "idAcusado" : 15
}
Listar rebeldes
Retorna todos os rebeldes e traidores cadastrados no banco de dados

Método GET: localhost:8080/rebelde/all
[
    {
        "id": 8,
        "nome": "Mars",
        "idade": 21,
        "genero": "M",
        "traidor": false,
        "localizacao": {
            "..."
        },
        "inventario": {
            "id": 9,
            "itens": [
                "..."
            ]
        }
    },
    {
        "id": 15,
        "nome": "Brenda",
        "idade": 21,
        "genero": "M",
        "traidor": true,
        "localizacao": {
           "..."
        },
        "inventario": {
            "id": 16,
            "itens": [
               "..."
            ]
        }
    }
]
Relatório
Retorna um simples relatório com algumas informações da resistencia

Método GET: localhost:8080/relatorio
{
    "porcentagemTraidores": 0,
    "porcentagemRebeldes": 0.01
}
