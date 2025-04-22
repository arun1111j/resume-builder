package com.resume.resume_builder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResumeBuilderApplication {
    public static void main(String[] args) {
        System.out.println("ENV PORT: " + System.getenv("PORT")); // Debug
        SpringApplication.run(ResumeBuilderApplication.class, args);
    }
}