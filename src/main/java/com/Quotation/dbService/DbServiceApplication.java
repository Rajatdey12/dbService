package com.Quotation.dbService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.Quotation.dbService.repository"})
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.Quotation.dbService.repository","com.Quotation.dbService.resource",
		"com.Quotation.dbService.model","com.Quotation.dbService.security","com.Quotation.dbService.service"})
public class DbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbServiceApplication.class, args);
	}

}