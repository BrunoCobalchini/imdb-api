# imdb-api
		Movie API

## Endpoints:

Actor // Por conter uma lista na entidade, achei que o get a seguir usa ela. Tambem usei essa regra para o POST E PUT pois na entidade Participation tem o optional = false então é orbigado a prencher a lista

GET /Actors
Resposta: [ { "id": "nm0000129", "name": "Tom Cruise", "birth_date": 01/01/01, ["participations": "id": "nm0000129", "name": "Tom Cruise", "birth_date": 01/01/01]}]

GET /Actors/{id} {"id": "nm0000129"}
Resposta: {"id": "nm0000129", "name": "Tom Cruise", "birth_date": 01/01/01, ["participations": "id": "nm0000129", "name": "Tom Cruise", "birth_date": 01/01/01]}

POST /Actors/{id}
Requisicao: POST /Actors/id {"id": "gak1234", "name": "Charlie Sheen", "birth_date": 02/02/02, ["participation": "id": "gak1234", "name": "Charlie Sheen", "birth_date": 02/02/02]}
GET /Actors/id {"id": "gak1234"}
Resposta: /Actors/id {"id": "gak1234", "name": "Charlie Sheen", "birth_date": 02/02/02, ["participation": "id": "gak1234", "name": "Charlie Sheen", "birth_date": 02/02/02]}

PUT /Actors/id 
Requisicao: PUT /Actors/id {"id": "gak1234", "name": "Adam Sandler", "birth_date": 12/11/10, ["participation": "id": "gak1234", "name": "Adam Sandler", "birth_date": 12/11/10]}
GET /Actors/id {"id": "gak1234"}
Resposta: {"id": "gak1234", "name": "Adam Sandler", "birth_date": 12/11/10, ["participation": "id": "gak1234", "name": "Adam Sandler", "birth_date": 12/11/10]}


DELETE /Actors/{id}
Requisicao: DELETE {"id":"gak1234"}
Resposta: GET /Actors/id {}


## Endpoints:

Movie // Por conter uma lista na entidade, achei que o get a seguir usa ela. Tambem usei essa regra para o POST E PUT, pois na entidade Participation tem o optional = false então é orbigado a prencher a lista

GET /Movies
Resposta:[{ "id": "abc2132", "name": "Titanic", "release_date": 23/12/1997, "rating": 4.8, "duration": 120,["participation": "id": "abc2132", "name": "Titanic", "release_date": 23/12/1997, "rating": 4.8, "duration": 120]}]

GET /Movies/id {"id": "abc2132"}
Resposta: { "id": "abc2132", "name": "Titanic", "release_date": 23/12/1997, "rating": 4.8, "duration": 120,["participation": "id": "abc2132", "name": "Titanic", "release_date": 23/12/1997, "rating": 4.8, "duration": 120]}

POST /Movies/id
Requisicao: POST /Movies/id {"id": "crk1992", "name": "The Godfather", "release_date": 12/05/1976, "rating": 4.9, "duration": 148,["participation":"id": "crk1992", "name": "The Godfather", "release_date": 12/05/1976, "rating": 4.9, "duration": 148]}
GET {"id": "crk1992"}
Resposta: {"id": "crk1992", "name": "The Godfather", "release_date": 12/05/1976, "rating": 4.9, "duration": 148,["participation":"id": "crk1992", "name": "The Godfather", "release_date": 12/05/1976, "rating": 4.9, "duration": 148]}

PUT /Movies/id 
Requisicao: PUT /Movies/id {"id": "crk1992", "name": "The Hero", "release_date": 01/09/1999, "rating": 2.8, "duration": 118,["participation":"id": "crk1992", "name": "The Hero", "release_date": 01/09/199, "rating": 2.8, "duration": 118]}
GET {"id": "crk1992"}
Resposta:{"id": "crk1992", "name": "The Hero", "release_date": 01/09/1999, "rating": 2.8, "duration": 118,["participation":"id": "crk1992", "name": "The Hero", "release_date": 01/09/199, "rating": 2.8, "duration": 118]}

DELETE /Movies/id
Requisicao: DELETE /Movies/id/name  {"name": "The Hero"}
GET {"id": "crk1992"}
Resposta: {"id": "crk1992", "name": " ", "release_date": 01/09/1999, "rating": 2.8, "duration": 118,["participation":"id": "crk1992", "name": " ", "release_date": 01/09/199, "rating": 2.8, "duration": 118]}


## Endpoints:

Participation     // Peguei o actor e o movie pelo ID das suas entidades padrões

GET /Participations
Resposta: [{"id": 1, "actor": "nm0000129", "movie": "abc2132"}]

GET /Participations/id {"id": 2}
Resposta: {"id": 2, "actor": "gak1234", "movie": "crk1992"}

POST /Participations/id
Requisicao: POST /Participations/id {"actor" "eoq1232", "movie": "vca2123"}
GET {"actor": "eoq1232"}
Resposta: {"id" 3, "actor" "eoq1232", "movie": "vca2123"}

PUT /Participations/id
Requisicao: PUT /Participations/id {"id": 3, "actor": "umdois2345", "movie": "var4997"}
GET {"id": 3}
Resposta: {"id": 3, "actor": "umdois2345", "movie": "var4997"}

DELETE /Participations/id
Requisicao: DELETE {"id": 3}
GET {"id": 3}
Resposta:{}


