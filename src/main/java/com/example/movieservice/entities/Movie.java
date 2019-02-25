package com.example.movieservice.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.movieservice.json.MyDateDeserializer;
import com.example.movieservice.json.MyDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="MOVIE_ID")
    private Long id;

    @Column(name="TITLE")
    private String title;

    @Temporal(TemporalType.DATE)
    @JsonSerialize(using=MyDateSerializer.class)
    @JsonDeserialize(using=MyDateDeserializer.class)
    @Column(name="RELEASE_DATE")
    private Date releaseDate;

    @Column(name="RATING")
    private int rating;

    public Movie() {}

    public Movie(String title) {
        this.title = title;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}