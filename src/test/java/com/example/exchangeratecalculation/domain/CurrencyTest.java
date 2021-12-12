package com.example.exchangeratecalculation.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

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

    @DisplayName("Currency 생성 실패 테스트 - Country가 null일 경우")
    @Test
    void createCurrencyFailWithCountryIsNull() {
        // given
        double exchangeRate = 1121.419945;

        //when
        Throwable thrown = catchThrowable(() -> {
            new Currency(null, exchangeRate);
        });

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Currency 생성 실패 테스트 - exchangeRate가 0보다 작은 경우")
    @Test
    void createCurrencyFailExchangeRateWithZero() {
        // given
        double exchangeRate = 0;

        //when
        Throwable thrown = catchThrowable(() -> {
            new Currency(Country.KRW, exchangeRate);
        });

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
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

    @DisplayName("Currency 환율 계산 테스트")
    @Test
    void calculateExchangeRateFailRemittanceWithZero() {
        // given
        double exchangeRate = 1121.419945;
        int remittance = 0;

        Currency currency = new Currency(Country.KRW, exchangeRate);

        //when
        Throwable thrown = catchThrowable(() -> {
            currency.calculateAmount(remittance);
        });

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

}
