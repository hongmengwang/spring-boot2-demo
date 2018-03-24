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
mvn clean package dockerfile:build
```
### Run
```sh
docker run -dt -p 8080:8080 wanghongmeng/spring-boot2-demo:1.0.0
```

## TODOs
- [ ] Integrate with CI
- [ ] Integrate with Code Review
