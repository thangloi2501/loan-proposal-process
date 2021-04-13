# Loan proposal process (banking)
## Configure application DB
Edit the below configuration in resources/application.properties file
```bash
spring.datasource.url= jdbc:h2:file:loan-proposal-process-db
```

## Build
```bash
mvn package
```

## Run
```bash
mvn spring-boot:run
```

## web app accessing

#### http://localhost:8080/
#### username: demo
#### password: demo

## loan proposal process