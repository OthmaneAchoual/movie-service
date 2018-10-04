package com.example.carservice.repositories;

import com.example.carservice.entities.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}