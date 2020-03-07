package com.juan.movies.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MovieRental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;
    private Date date;
    private Date toReturnDate;
    private Date returnedDate;
    @OneToOne(cascade = CascadeType.ALL)
    private Price price;
    @Column(name="status",columnDefinition = "varchar(25) default NULL")
    private String status;
}
