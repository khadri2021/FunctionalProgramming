package com.khadri.function.programming.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(value = "com.khadri.function.programming" )
@EnableJpaRepositories( value = "com.khadri.function.programming.dao")
@EntityScan(value = "com.khadri.function.programming.entity")
public class FunctionalProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunctionalProgrammingApplication.class, args);
	}

}
