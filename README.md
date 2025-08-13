# Spring Boot Redis

## 1. 설명
Spring Boot 3.5 Redis CRUD 예제이다. 포트는 8080을 사용한다.

## 2. 개발환경

* OpenJDK 17

* spring-boot 3.5.4

* spring-boot-starter-data-redis

* org.projectlombok 1.18.38

## 4. Rest API 실행

### 1) 사용자 생성

* URL: `http://localhost:8080/users`

* Method: `POST`

* Params

```json
{
    "id": "user1",
    "name": "Alice",
    "age": 30
}
```

### 2) 사용자 조회

* URL: `http://localhost:8080/users/user1`

* Method: `GET`

### 3) 전체 사용자 조회

* URL: `http://localhost:8080/users`

* Method: `GET`

### 4) 사용자 수정

* URL: `http://localhost:8080/users/user1`

* Method: `PUT`

* Params

```json
{
    "name": "Alice Smith",
    "age": 31
}
```

### 5) 사용자 삭제

* URL: `http://localhost:8080/users/user1 `

* Method: `DELETE`
