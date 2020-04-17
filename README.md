# Project name: imdb-api


![alt text](https://i.imgur.com/lSDCC4g.png)	
	
# *Endpoints: actors*
```java

GET /actors
	[{ "id": "nm0001191", "name": "Adam Sandler", "birth_date": "1966-09-09", "participations": [ ]}, { "id": "nm0001618", "name": "Joaquin Phoenix", "birth_date": "1974-10-28", "participations": [ ]}, { "id": "nm0000375", "name": "Robert Downey Jr", "birth_date": "1965-04-04", "participations": [ ]}]
```
```java
GET /actors/{id}
	{"id": "nm0001191", "name": "Adam Sandler", "birth_date": "1966-09-09", "participations": [ ]}

```
```java

POST /actors/{id}
	/actors/nm0001618 {"name": "Joaquin Phoenix", "birth_date": "1974-10-28", "participations": [ ]}

	BODY { "id": "nm0001618", "name": "Joaquin Phoenix", "birth_date": "1974-10-28", "participations": [ ]}

```
```java

PUT /actors/id 
	PUT /actors/nm0001618 {"name": "Chitaozinho"}

	BODY { "id": "nm0001618", "name": "Chitaozinho", "birth_date": "1974-10-28", "participations": [ ]}

```
```java

DELETE /actors/{id}
	DELETE /actors/nm0001618

```
# *Endpoints: movies*
```java 
```
```java

GET /movies
	[{ "id": "abc2132", "name": "Titanic", "release_date": "1979-11-25", "rating": 4.8, "duration": 120,"participations": [ ]},{"id": "crk1992", "name": "The Hero", "release_date": "1983-05-20", "rating": 2.8, "duration": 118,"participations": [ ]}]

```
```java

GET /movies/id
	 /movies/abc2132  { "id": "abc2132", "name": "Titanic", "release_date": "1979-11-25", "rating": 4.8, "duration": 120,"participations": [ ]}

```
```java

POST /movies/id
	POST /movies/crk1992 {"name": "The Godfather", "release_date": "1976-10-09", "rating": 4.9, "duration": 148, "participations": [ ]}

	BODY - {"id": "crk1992", "name": "The Godfather", "release_date": "1976-10-09", "rating": 4.9, "duration": 148,"participations": [ ]}

```
```java

PUT /movies/id 
	PUT /movies/crk1992 {"name": "The Hero"}

	BODY - {"id": "crk1992", "name": "The Hero", "release_date": "1976-10-09", "rating": 4.9, "duration": 148,"participations": [ ]}

```
```java

DELETE /movies/id
		/movies/crk1992
		
```

# *Endpoints: participations* 
```java 
```
```java
GET /participations
	[{"id": 1, "actors": "nm0000129", "movies": "abc2132"}]

GET /participations/id 
	/participations/1 {"id": 1, "actors": "nm0000129", "movies": "abc2132"}
```
```java

POST /participations
	POST /participations {"actors" "eoq1232", "movies": "vca2123"}

	BODY - {"id" 2, "actors" "eoq1232", "movies": "vca2123"}
```
```java

PUT /participations/id
	PUT /participations/2 {"actors": "umdois2345", "movies": "var4997"}

	BODY - {"id": 2, "actors": "umdois2345", "movies": "var4997"}
```
```java

DELETE /participations/id
		/participations/2