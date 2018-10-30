package com.example.carservice.controllers;

import java.util.List;

import com.example.carservice.entities.Movie;
import com.example.carservice.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieRepository repository;

    @GetMapping("")
    public List<Movie> all() {
        return this.repository.findAll();
    }

    @GetMapping("/top")
    public List<Movie> topRated() {
        return this.repository.findTop3ByOrderByRatingDesc();
    }
}