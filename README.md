# Movies REST API Service

Basic REST API using Java Spring Boot.

## REST Service

### Features
  - This API supports Movie catalog and movie Rental.
  - It is a Tomcat embedded app.
  - Support JSON media content.
  - Uses MySQL for saving data.
  - Uses JPA for persistence operations

### Routes

#### Get movies

| Verb | URI Pattern | Return |
| ------ | ------ | ------ |
| GET | /api/movies | Array |

#### Post movie

| Verb | URI Pattern | Return |
| ------ | ------ | ------ |
| POST | /api/movie| String |

##### Body

```json
{
    "title": "abcdefhijklmnopqrstuvwxyzabcdefhijklmnopqrstuvwxyzabcdefhijklmnopqrstuvwxyz",
    "description": "BlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlah",
    "year": "2020-05-05",
    "rate": "PG",
    "registeringUser": "Erika",
    "actors": [
        101,
        102,
        103,
        104
    ]
}
```

#### Post member

| Verb | URI Pattern | Return |
| ------ | ------ | ------ |
| POST | /api/member | String |


##### Body

```json
{
	"username": "abcdef@gmail.com",
	"name": "abcdefhijklmnabcdefhijklmnabcdefhijklmnabcdefhijklmnabcdefhijklmnabcdefhijklmnabcdefhijklmnabcdefhijklmnabcdefhijklmnabcdefhijklmnabcdefhijklmnabcdefhijklmnabcdefhijk",
	"telephone": "1234567890"
}
```

#### Post movie catalog

| Verb | URI Pattern | Return |
| ------ | ------ | ------ |
| POST | /api/catalog-entry | String |

##### Body

```json
{
	"movie": 108,
	"price": 105,
	"numberofCopies": 7
}
```

#### Post movie rental

| Verb | URI Pattern | Return |
| ------ | ------ | ------ |
| POST | /api/rental | String |

##### Body

```json
{
	"memberId": 101,
	"movieId": 101,
	"date": "2020-05-01"
}
```

#### Patch movie rental

| Verb | URI Pattern | Return |
| ------ | ------ | ------ |
| PATCH | /api/rental/:id | String |

##### Body

```json
{
	"status": "Returned"
}
```

### Unit tests

There are JUnit unit tests for services and controllers on `src/test`.

### SQL migration file

There is a SQL migration file with valid data on `src/main/resources/data.sql`.

### Important

The most important changed files are:
  - Controllers: `src/main/java/com/juan/movies/controller` - All REST controllers for each model and exception handler
  - Models: `src/main/java/com/juan/movies/model` - All entity models to be mapped using JPA
  - Repositories: `src/main/java/com/juan/movies/repository` - All models' repositories interfaces
  - Services: `src/main/java/com/juan/movies/service` - Services and implementations for each model
  - Utils: `src/main/java/com/juan/movies/utils` - Utilities like date updater
  - Tests: `src/test` - JUnit tests for controllers and services.

## Todos

 - Generate unit test for models.
 - Exception handling for `SQLIntegrityConstraintViolationException`.
 - Can't use Mockito on services. It did not worked.

License
----

MIT
