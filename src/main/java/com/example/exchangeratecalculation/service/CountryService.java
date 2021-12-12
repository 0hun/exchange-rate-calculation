package com.example.exchangeratecalculation.service;

import com.example.exchangeratecalculation.domain.Country;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    public List<Country> find() {
        return Country.currencies();
    }

}
