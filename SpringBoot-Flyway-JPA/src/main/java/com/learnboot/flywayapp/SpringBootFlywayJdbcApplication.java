package com.learnboot.flywayapp;

import com.learnboot.flywayapp.model.Order;
import com.learnboot.flywayapp.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;


@SpringBootApplication
public class SpringBootFlywayJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFlywayJdbcApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(OrderRepository Orders){
		return args -> {
			Order order = new Order();
			order.setOrderNumber("20240627001");
			order.setOrderRefNumber("20240627001REF");
			order.setOrderVersion("1");
			order.setOrderCreationDate(new Date());
			Orders.save(order);
		};
	}
}
