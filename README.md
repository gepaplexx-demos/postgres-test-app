# postgres-test-app Project

## running the application in dev mode

```
docker run --name postgresql-container -p 5432:5432 -e POSTGRES_PASSWORD=hibernate --rm -d postgres
```

```
mvn quarkus:dev
```
