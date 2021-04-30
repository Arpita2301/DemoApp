package com.project.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.project.example.repository")
@EntityScan("com.project.example.entity")
public class DemoApplication {
    public static void main(String[] args) {
        System.out.println("hi");
        SpringApplication.run(DemoApplication.class, args);
    }
}
