package com.example.movieservice.repositories;

import java.util.List;

import com.example.movieservice.entities.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findTop3ByOrderByRatingDesc();
    List<Movie> findTop3ByOrderByReleaseDateDesc();

    @Query("Select m From Movie m Where DIRECTOR_ID = ?1")
    List<Movie> findMoviesForDirector(Long directorId);
}