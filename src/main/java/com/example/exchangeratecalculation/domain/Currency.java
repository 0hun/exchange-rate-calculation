package com.example.exchangeratecalculation.domain;

import lombok.Getter;

@Getter
public class Currency {

    private final String nation;

    private final double exchangeRate;

    public Currency(String nation, double exchangeRate) {
        this.nation = nation;
        this.exchangeRate = exchangeRate;
    }

    public double calculateAmount(int remittance) {
        return exchangeRate * remittance;
    }

}
