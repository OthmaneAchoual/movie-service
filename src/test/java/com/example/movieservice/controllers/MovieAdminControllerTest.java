package com.example.movieservice.controllers;

import com.example.movieservice.repositories.MovieRepository;
import com.example.movieservice.services.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieAdminController.class)
public class MovieAdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService service;

    @MockBean
    private MovieRepository repository;

    @Test
    public void passingGoodParam() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/admin/movie/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"title\":\"foo\"}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}
