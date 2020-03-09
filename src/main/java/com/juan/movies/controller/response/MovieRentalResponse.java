package com.juan.movies.controller.response;

import com.juan.movies.model.Member;
import com.juan.movies.model.Movie;
import com.juan.movies.model.Price;

import javax.persistence.*;
import java.util.Date;

public class MovieRentalResponse {
    private int id;
    private int memberId;
    private int movieId;
    private Date date;
    private Date toReturnDate;
    private Date returnedDate;
    private String price;
    private String status;
}
