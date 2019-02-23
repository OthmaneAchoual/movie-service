package com.example.carservice.services;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 997f7dcc8136569259f45237513acb2db545f9a8
import com.example.carservice.entities.Movie;
import com.example.carservice.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

<<<<<<< HEAD
  private MovieRepository repository;

  @Autowired
  public MovieService(MovieRepository repository) {
    this.repository = repository;
  }
=======
  @Autowired
  private MovieRepository repository;
>>>>>>> 997f7dcc8136569259f45237513acb2db545f9a8

  public Page<Movie> all(int page) {
    return this.repository.findAll(PageRequest.of(page, 2));
  }
<<<<<<< HEAD
  
  public List<Movie> topRated() {
    return this.repository.findTop3ByOrderByRatingDesc();
  }
  
  public List<Movie> latest() {
    return this.repository.findTop3ByOrderByReleaseDateDesc();
  }
=======
>>>>>>> 997f7dcc8136569259f45237513acb2db545f9a8

}