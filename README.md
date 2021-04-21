# Loan Credit Proposal Process (Banking)
## Configure application DB
Edit the below configuration in resources/application.properties file
```bash
spring.datasource.url= jdbc:h2:file:./camunda-demo
```

## Build
```bash
mvn package
```

## Run
```bash
mvn spring-boot:run
```

## Camunda Web Management

#### http://localhost:8080/
#### username: demo
#### password: demo
