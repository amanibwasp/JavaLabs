package org.example.entity;

import java.time.LocalDateTime;

public class Session {
    public Movie movie;
    public Hall hall;
    public LocalDateTime startTime;
    public Cinema cinema;

    public Session(Movie movie, Hall hall, LocalDateTime startTime, Cinema cinema) {
        this.movie = movie;
        this.hall = hall;
        this.startTime = startTime;
        this.cinema = cinema;
    }
}