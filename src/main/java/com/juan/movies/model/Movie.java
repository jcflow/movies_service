package com.juan.movies.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    @Length(min = 50)
    private String title;
    @NotNull
    private Date year;
    @NotNull
    @Length(min = 100)
    private String description;
    @NotNull
    @Pattern(regexp = "^(G|PG|PG-13|R|NC-17)$")
    private String rate = "G";
    @ManyToOne
    @JoinColumn(name="registering_user")
    private User registeringUser;
    @ManyToOne
    @JoinColumn(name="updating_user")
    private User updatingUser;
    private boolean deleted = false;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> actors = new HashSet<>();

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public User getRegisteringUser() {
        return registeringUser;
    }

    public void setRegisteringUser(User registeringUser) {
        this.registeringUser = registeringUser;
    }

    public User getUpdatingUser() {
        return updatingUser;
    }

    public void setUpdatingUser(User updatingUser) {
        this.updatingUser = updatingUser;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }
}
