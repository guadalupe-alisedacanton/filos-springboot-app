package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

import static java.time.Month.*;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student alice = new Student(
                    "Alice",
                    "alice@usc.edu",
                    LocalDate.of(2002, SEPTEMBER, 30),
                    "Computer Science",
                    "Sophomore"
            );
            Student bob = new Student(
                    "Bob",
                    "bob@usc.edu",
                    LocalDate.of(1997, OCTOBER, 23),
                    "Business",
                    "Junior"
            );

            repository.saveAll(List.of(alice, bob));

        };
    }
}
