# Loan Credit Proposal Process (Banking)

![alt text](https://github.com/thangloi2501/loan-proposal-process/blob/master/loan-process.jpg?raw=true)

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
