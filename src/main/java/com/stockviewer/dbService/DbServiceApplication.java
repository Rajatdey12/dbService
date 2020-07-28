package com.stockviewer.dbService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.stockviewer.dbService.repository"})
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.stockviewer.dbService.repository","com.stockviewer.dbService.resource","com.stockviewer.dbService.repository.model"})
public class DbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbServiceApplication.class, args);
	}

}