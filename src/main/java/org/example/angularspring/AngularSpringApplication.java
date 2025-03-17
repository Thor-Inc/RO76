package org.example.angularspring;

import org.example.angularspring.entity.User;
import org.example.angularspring.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class AngularSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AngularSpringApplication.class, args);
    }

}
