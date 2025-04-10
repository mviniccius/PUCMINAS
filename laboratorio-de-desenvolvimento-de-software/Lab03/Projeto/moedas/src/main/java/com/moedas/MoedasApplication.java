package com.moedas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.moedas.repository")
public class MoedasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoedasApplication.class, args);
	}

}
