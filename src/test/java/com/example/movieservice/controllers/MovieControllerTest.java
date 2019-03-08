package com.example.movieservice.controllers;

import com.example.movieservice.entities.Movie;
import com.example.movieservice.repositories.MovieRepository;
import com.example.movieservice.services.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class) // Only initialize the web layer, not whole context only with specified controllers
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieRepository repository;

    @MockBean
    private MovieService service;

    @Test
    public void testLatest() throws Exception {
        Mockito.when(service.latest()).thenReturn(Arrays.asList(new Movie("Black Hawk Down")));
        this.mockMvc.perform(get("/api/movie/latest"))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", "application/json;charset=UTF-8"))
                .andExpect(content().string(containsString("Black Hawk Down")));
    }

    @Test
    public void testDummy() throws Exception {
        Mockito.when(service.latest()).thenReturn(Arrays.asList(new Movie("Black Hawk Down")));
        this.mockMvc.perform(get("/api/movie/foo"))
                .andExpect(status().isNotFound());
    }
}
