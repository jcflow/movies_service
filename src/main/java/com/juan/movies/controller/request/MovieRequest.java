package com.juan.movies.controller.request;

import java.util.*;

public class MovieRequest {
    private String title;
    private Date year;
    private String Description;
    private String rate;
    private String registeringUser;
    private List<Integer> actors = new ArrayList<>();

    public MovieRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRegisteringUser() {
        return registeringUser;
    }

    public void setRegisteringUser(String registeringUser) {
        this.registeringUser = registeringUser;
    }

    public List<Integer> getActors() {
        return actors;
    }

    public void setActors(List<Integer> actors) {
        this.actors = actors;
    }
}
