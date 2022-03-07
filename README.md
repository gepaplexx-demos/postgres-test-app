# postgres-test-app Project

## running the application in dev mode

```
docker run --name postgresql-container -p 5432:5432 -e POSTGRES_PASSWORD=hibernate --rm -d postgres
```

```
mvn quarkus:dev
```

## Build for MySQL

```
mvn -D quarkus.datasource.db-kind=mysql package

docker build -f src/main/docker/Dockerfile.jvm -t db-test-app-jvm:mysql-1.1 .
```
