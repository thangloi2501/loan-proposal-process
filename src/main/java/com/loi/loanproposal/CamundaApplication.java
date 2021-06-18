package com.loi.loanproposal;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication("loan-proposal-process")
/**
 * @author Loi Nguyen
 */
public class CamundaApplication{
	public static void main(String... args) {
		SpringApplication.run(CamundaApplication.class, args);
	}
}
