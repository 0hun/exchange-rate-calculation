package com.example.exchangeratecalculation.domain;

import lombok.Getter;

@Getter
public class Currency {

    private final Country country;

    private final double exchangeRate;

    public Currency(Country country, double exchangeRate) {
        this.country = country;
        this.exchangeRate = exchangeRate;
    }

    public double calculateAmount(int remittance) {
        return exchangeRate * remittance;
    }

}
