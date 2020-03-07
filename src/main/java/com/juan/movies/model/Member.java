package com.juan.movies.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Length(max = 150)
    @Pattern(regexp="^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$", message="should be an email address.")
    @Column(name = "username", nullable = false)
    private String username;
    @Length(min = 100)
    @Column(name = "name", nullable = false)
    private String name;
    private String telephone;
}