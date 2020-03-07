package com.juan.movies.model;

import javax.persistence.*;

@Entity
public class MovieCatalog {
    @Id
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    @MapsId
    private Movie movie;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_id", nullable = false)
    private Price price;

    private int numberOfCopies = 0;

    public MovieCatalog() {
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }
}
