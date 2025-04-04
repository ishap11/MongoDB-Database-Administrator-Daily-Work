package com.example.MongoDBAuth;

import com.example.MongoDBAuth.service.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongoDbAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbAuthApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(AuthenticationService authenticationService) {
        return args -> {
            // Ask user for credentials and authenticate
            authenticationService.askUserForCredentials();
        };
    }
}
