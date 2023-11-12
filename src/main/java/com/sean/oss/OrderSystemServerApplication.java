package com.sean.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		servers = {@Server(url = "/", description = "Default Server URL")}
)
@SpringBootApplication
public class OrderSystemServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderSystemServerApplication.class, args);
	}

}
