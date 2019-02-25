package com.example.movieservice.controllers;

import com.example.movieservice.entities.Movie;
import com.example.movieservice.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/movie")
public class MovieAdminController {

    @Autowired
    private MovieRepository repository;

    @PostMapping("")
    public Movie add(@RequestBody Movie movie) {
        return this.repository.save(movie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.repository.deleteById(id);
    }
}