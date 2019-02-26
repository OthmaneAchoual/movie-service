package com.example.movieservice;

import com.example.movieservice.repositories.MovieRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@SpringBootApplication
@PropertySource("classpath:custom.properties")
public class MovieServiceApplication {

  @Autowired
  private Environment env;

  private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceApplication.class);
  
	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}

  // Titanic 1997-11-18
  // Matrix 1999-03-24
  // Fight Club 1999-09-21
	@Bean
	CommandLineRunner runner(MovieRepository repository) {
		return args -> {

      LOGGER.info(env.getProperty("greeting.msg"));

      repository.findAll()
        .stream()
        .filter(movie -> movie.getDirector() != null)
        .map(movie -> movie.getTitle() + " " + movie.getDirector().getFirstname() + ", " + movie.getDirector().getLastname())
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
