package com.learnboot.flywayapp;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;


@SpringBootApplication
public class SpringBootFlywayJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFlywayJpaApplication.class, args);
	}

	@Bean
	public ObjectMapper jacksonBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		return builder.build();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {

		return builder.setConnectTimeout(Duration.ofMillis(300000))
				.setReadTimeout(Duration.ofMillis(300000)).build();
	}
}
