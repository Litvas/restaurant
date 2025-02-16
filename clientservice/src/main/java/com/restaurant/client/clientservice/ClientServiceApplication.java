package com.restaurant.client.clientservice;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientServiceApplication {

    public static void main(String[] args) {
        Dotenv.load().entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
        SpringApplication.run(ClientServiceApplication.class, args);
    }

}
