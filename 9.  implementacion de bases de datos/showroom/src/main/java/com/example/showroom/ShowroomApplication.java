package com.example.showroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ShowroomApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowroomApplication.class, args);
    }

}
