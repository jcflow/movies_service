package com.juan.movies.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MovieRentalRequest {
    private int memberId;
    private int movieId;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    public MovieRentalRequest() {
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
