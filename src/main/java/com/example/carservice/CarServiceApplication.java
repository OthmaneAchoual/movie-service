package com.example.carservice;

import java.util.Arrays;

import com.example.carservice.entities.Movie;
import com.example.carservice.repositories.MovieRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(MovieRepository repository) {
		return args -> {
			Arrays.asList("Titanic", "Matrix", "Fight Club")
				.stream()
				.map(Movie::new)
				.forEach(repository::save);
		};
	}
}
