package com.example.movieservice.repositories;

import com.example.movieservice.entities.Movie;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository repository;

    @Test
    public void moviesByDirectorQueryWorks() {
        var fincherMovies = repository.findMoviesForDirector(2L);
        assertThat(fincherMovies.size(), is(2));
    }
}
