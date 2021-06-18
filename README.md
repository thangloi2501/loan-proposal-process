# Loan Credit Proposal Process (Banking) [![Build Status](https://travis-ci.org/thangloi2501/loan-proposal-process.svg?branch=master)](https://travis-ci.org/thangloi2501/travis-badge)
![alt text](https://github.com/thangloi2501/loan-proposal-process/blob/master/loan-process.png?raw=true)

## Configure application DB
Edit the below configuration in resources/application.yaml file
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

## Authors and acknowledgment
Loi Nguyen - https://www.linkedin.com/in/loi-nguyen-thang/
