package com.example.exchangeratecalculation.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountryTest {

    @DisplayName("Nation 환율 정보 코드로 enum 찾기 테스트")
    @Test
    void find() {
        // given
        String currencyCode = "USDKRW";

        // when
        Country country = Country.find(currencyCode);

        // then
        assertThat(country).isEqualTo(Country.KRW);
    }

    @DisplayName("Nation 환율 정보 코드로 enum 찾기 테스트")
    @Test
    void findFail() {
        // given
        String currencyCode = "USDKRW11";

        //when
        Throwable thrown = catchThrowable(() -> {
            Country.find(currencyCode);
        });

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

}
