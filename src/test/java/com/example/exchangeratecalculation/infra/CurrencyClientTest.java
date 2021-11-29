package com.example.exchangeratecalculation.infra;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CurrencyClientTest {

    @Test
    void send() {
        // given
        CurrencyClient currencyClient = new CurrencyLayerClient();

        // when
        String result = currencyClient.currentCurrencies();

        // then
        assertThat(result).isNotNull();
    }

}
