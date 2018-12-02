package com.example.carservice;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

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

  // Titanic 1997-11-18
  // Matrix 1999-03-24
  // Fight Club 1999-09-21
	@Bean
	CommandLineRunner runner(MovieRepository repository) {
		return args -> {

      repository.findAll()
        .stream()
        .map(Movie::getTitle)
        .forEach(System.out::println);
        
      // final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

      // Movie titanic = new Movie("Titanic");
      // Movie matrix = new Movie("Matrix");
      // Movie fightclub = new Movie("Fight Club");

      // titanic.setReleaseDate(format.parse("1997-11-18"));
      // titanic.setRating(4);

      // matrix.setReleaseDate(format.parse("1999-03-24"));
      // matrix.setRating(5);

      // fightclub.setReleaseDate(format.parse("1999-09-21"));
      // fightclub.setRating(5);

      // Arrays.asList(titanic, matrix, fightclub)
      // 	.forEach(repository::save);
      
			// Arrays.asList("Titanic", "Matrix", "Fight Club")
      //   .stream()
			// 	.map(Movie::new)
			// 	.forEach(repository::save);
    };
	}
}
