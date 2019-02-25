package com.example.movieservice.repositories;

import java.util.List;

import com.example.movieservice.entities.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findTop3ByOrderByRatingDesc();
    List<Movie> findTop3ByOrderByReleaseDateDesc();
}