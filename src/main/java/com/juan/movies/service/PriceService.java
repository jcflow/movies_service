package com.juan.movies.service;

import com.juan.movies.model.Price;

public interface PriceService {
    Price findById(int movieId);
}
