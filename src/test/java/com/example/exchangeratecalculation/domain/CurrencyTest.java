package com.example.exchangeratecalculation.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CurrencyTest {

    @DisplayName("Currency 생성 테스트")
    @Test
    void createCurrency() {
        // given
        double exchangeRate = 1121.419945;

        // when
        Currency currency = new Currency(Country.KRW, exchangeRate);

        // then
        assertThat(currency).isNotNull();
    }

    @DisplayName("Currency 환율 계산 테스트")
    @Test
    void calculateExchangeRate() {
        // given
        double exchangeRate = 1121.419945;
        int remittance = 100;

        // when
        Currency currency = new Currency(Country.KRW, exchangeRate);

        double amount = currency.calculateAmount(remittance);

        // then
        assertThat(amount).isNotNull();
    }

}
