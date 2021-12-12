package com.example.exchangeratecalculation.domain;

import lombok.Getter;

@Getter
public class Currency {

    private final Country country;

    private final double exchangeRate;

    public Currency(Country country, double exchangeRate) {
        validateCountry(country);
        validateExchangeRate(exchangeRate);

        this.country = country;
        this.exchangeRate = exchangeRate;
    }

    public void validateCountry(Country country) {
        if (country == null) {
            throw new IllegalArgumentException();
        }
    }

    public void validateExchangeRate(double exchangeRate) {
        if (exchangeRate <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public double calculateAmount(int remittance) {
        validateRemittance(remittance);

        return exchangeRate * remittance;
    }

    public void validateRemittance(int remittance) {
        if (remittance <= 0) {
            throw new IllegalArgumentException();
        }
    }

}
