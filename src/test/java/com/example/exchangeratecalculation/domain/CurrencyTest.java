package com.example.exchangeratecalculation.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CurrencyTest {

    @DisplayName("Currency 생성 테스트")
    @Test
    void createCurrency() {
        // given
        String nation = "KRW";
        double exchangeRate = 1121.419945;

        // when
        Currency currency = new Currency(nation, exchangeRate);

        // then
        assertThat(currency).isNotNull();
    }

    @DisplayName("Currency 환율 계산 테스트")
    @Test
    void calculateExchangeRate() {
        // given
        String nation = "KRW";
        double exchangeRate = 1121.419945;
        int remittance = 100;

        // when
        Currency currency = new Currency(nation, exchangeRate);

        double amount = currency.calculateAmount(remittance);

        // then
        assertThat(amount).isNotNull();
    }

}
