# Spring Boot2 Demo
This is the demo of spring boot2

- - -
## Architecture
* [Spring Boot](https://projects.spring.io/spring-boot)
* [Maven](https://maven.apache.org)
* [H2 Database](http://www.h2database.com/html/main.html)
* [JUnit5](https://junit.org/junit5)
* [Mybatis](http://www.mybatis.org/mybatis-3)
* [Swagger](http://springfox.github.io/springfox/docs/current)
* [Hateoas](https://projects.spring.io/spring-hateoas)
* [Logback](https://logback.qos.ch)
* [SLF4J](https://www.slf4j.org)
* [Logback](https://logback.qos.ch)
* [Lombok](https://projectlombok.org)
* [JSON API](http://jsonapi.org/recommendations)

## Installation
### Build
Please install java8/maven/git on your laptop before start
```sh
git@github.com:hongmengwang/spring-boot2-demo.git
cd spring-boot2-demo
mvn clean package -U -B
```
### Run
```sh
java -jar target/spring-boot2-demo.jar
```
### Access API Document
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- - -

## Features
### API Version
Api has version control in the url, like **http://localhost:8080/v1/departments**, **http://localhost:8080/v2/departments**.
If the input/output has changed, you must change the version number, and keep all versions are available unless you are sure that one version is not used any more.
### API URL
The URL definition is follow the rest rules, for concrete concept please refer to [JSON API]
Examples:
```
http://localhost:8080/v1/departments
http://localhost:8080/v1/departments/00001
http://localhost:8080/v1/departments/000001/employees
http://localhost:8080/v1/departments?query=xxx&page=1&sort=id
```
### API Parameter
All the input/output parameter names are SNAKE_CASE format, the framework will automatically convert snake_case to camelCase, and set the values into your entity/dto
### Examples
| Operation&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; | Http&nbsp;Type | Curl Command |
| -------- | -------- | -------- |
| Get Departments | `GET` | curl --request GET --url http://localhost:8080/v1/departments |
| Add Department | `POST` | curl --request POST --url http://localhost:8080/v1/departments --header 'Content-Type: application/json' --data '{"id":1, "name":"Data Science", "floor":11, "created_by":"wang", "updated_by":"wang"}'|
| Update Department | `PUT` | curl --request PUT --url http://localhost:8080/v1/departments --header 'Content-Type: application/json' --data '{"id":"0000001", "name":"Data Section", "floor":12, "updated_by":"wang"}' |
| Delete Department | `DELETE` | curl --request DELETE --url http://localhost:8080/v1/departments/0000001 |

### Unit Test
Execute `mvn clean test` to do the unit test, and it will also generate test coverage report, the report is under target/site/jacoco, please open **index.html** in browser
- - -

## TODOs
- [ ] Integrate with CI
- [ ] Integrate with Code Review
