package com.juan.movies.service;

import com.juan.movies.controller.exception.PriceNotFoundException;
import com.juan.movies.model.Price;
import com.juan.movies.repository.MovieRepository;
import com.juan.movies.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PriceServiceImplementation implements PriceService {
    @Autowired
    private PriceRepository priceRepository;

    @Override
    public Price findById(int priceId) {
        Optional<Price> price = priceRepository.findById(priceId);
        if (!price.isPresent()) {
            throw new PriceNotFoundException();
        }
        return price.get();
    }
}
