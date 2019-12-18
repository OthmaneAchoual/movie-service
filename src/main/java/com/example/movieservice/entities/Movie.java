package com.example.movieservice.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.movieservice.json.MyDateDeserializer;
import com.example.movieservice.json.MyDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@Table(name="MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="MOVIE_ID")
    private Long id;

    @Column(name="TITLE")
    @NotBlank
    private String title;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="DIRECTOR_ID")
    private Director director;

    @JsonSerialize(using=MyDateSerializer.class)
    @JsonDeserialize(using=MyDateDeserializer.class)
    @Column(name="RELEASE_DATE")
    private LocalDate releaseDate;

    @Column(name="RATING")
    @NotNull
    private int rating;

    public Movie() {}

    public Movie(String title) {
        this.title = title;
    }
}