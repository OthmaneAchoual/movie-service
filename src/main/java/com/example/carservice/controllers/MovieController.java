package com.example.carservice.controllers;

import java.util.List;

import com.example.carservice.entities.Movie;
import com.example.carservice.services.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping("")
    public Page<Movie> all(@RequestParam("p") int page) {
        return this.service.all(page);
    }

    @GetMapping("/top")
    public List<Movie> topRated() {
        return this.service.topRated();
    }

    @GetMapping("/latest")
    public List<Movie> latest() {
        return this.service.latest();
    }
}