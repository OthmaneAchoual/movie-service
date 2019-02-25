package com.example.movieservice;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import com.example.movieservice.entities.Director;
import com.example.movieservice.entities.Movie;
import com.example.movieservice.repositories.MovieRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MovieServiceApplicationTests {

  @Autowired
  private MovieRepository repository;

	@Test
	public void contextLoads() {
  }
  
  @Test
  public void movieTest() {
    Movie movie = new Movie("Foo");
    this.repository.save(movie);
    
    assertThat(movie.getTitle(), is("Foo"));
  }

  @Test
  public void directorTest() {
    Director director = new Director();
  }

}
