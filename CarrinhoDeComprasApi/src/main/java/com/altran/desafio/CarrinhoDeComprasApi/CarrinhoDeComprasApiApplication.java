package com.altran.desafio.CarrinhoDeComprasApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoAuditing
@EnableMongoRepositories(value = "com.altran.desafio.CarrinhoDeComprasApi.repository", considerNestedRepositories = true)
public class CarrinhoDeComprasApiApplication {

	public static void main(String[] args) {
		  System.getProperties().put( "server.port", 8181 );
		SpringApplication.run(CarrinhoDeComprasApiApplication.class, args);
	}

}
