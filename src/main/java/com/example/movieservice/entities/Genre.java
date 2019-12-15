package com.example.movieservice.entities;

public enum Genre {
    Polar("A good genre") {
        public int code() { return 5; }
    },

    SciFi("May never happen") {
        public int code() { return 4; }
    };

    private String description;

    Genre(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract int code();
}