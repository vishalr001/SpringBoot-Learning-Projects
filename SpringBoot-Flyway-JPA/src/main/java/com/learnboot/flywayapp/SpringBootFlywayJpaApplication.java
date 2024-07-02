package com.learnboot.flywayapp;


import com.learnboot.flywayapp.model.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;


@SpringBootApplication
public class SpringBootFlywayJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFlywayJpaApplication.class, args);
	}
}
