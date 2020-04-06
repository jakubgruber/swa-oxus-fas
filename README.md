Frontend Application Service
---

The service serves as an entry point to example Loan Application.

# Getting Started

## Build

```
mvn clean package
```

## Dockerize

```
sudo docker build -t fas:v1 .
```

## Start container

```
sudo docker run -d -p 8989:8989 -t fas:v1
```

## App Url

`localhost:8989`

## Example request:

```
curl -H 'Content-Type: application/json' -d '{"clientId": 1, "loanAmount": 10000, "callbackUrl": "localhost:8082/callbackUrl"}' -X POST http://localhost:8989/loan/request
```