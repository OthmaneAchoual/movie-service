package com.example.carservice.controllers;

import java.util.List;

import com.example.carservice.entities.Movie;
import com.example.carservice.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieRepository repository;

    @GetMapping("")
    public Page<Movie> all(@RequestParam("p") int page) {
        System.out.println(page);
        return this.repository.findAll(PageRequest.of(page, 2));
        // return this.repository.findAll();
    }

    @GetMapping("/top")
    public List<Movie> topRated() {
        return this.repository.findTop3ByOrderByRatingDesc();
    }

    @GetMapping("/latest")
    public List<Movie> latest() {
        return this.repository.findTop3ByOrderByReleaseDateDesc();
    }
}