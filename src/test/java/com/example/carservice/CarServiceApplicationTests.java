package com.example.carservice;

import static org.junit.Assert.assertEquals;

import com.example.carservice.entities.Movie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceApplicationTests {

	@Test
	public void contextLoads() {
  }
  
  @Test
  public void movieTest() {
    Movie movie = new Movie("Foo");

    assertEquals("Movie title not set correctly through constructor", "Foo", movie.getTitle());
  }

}
