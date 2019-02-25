package com.example.movieservice.services;

import java.util.List;

import com.example.movieservice.entities.Movie;
import com.example.movieservice.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  private MovieRepository repository;

  @Autowired
  public MovieService(MovieRepository repository) {
    this.repository = repository;
  }

  public Page<Movie> all(int page) {
    return this.repository.findAll(PageRequest.of(page, 2));
  }
  
  public List<Movie> topRated() {
    return this.repository.findTop3ByOrderByRatingDesc();
  }
  
  public List<Movie> latest() {
    return this.repository.findTop3ByOrderByReleaseDateDesc();
  }

}