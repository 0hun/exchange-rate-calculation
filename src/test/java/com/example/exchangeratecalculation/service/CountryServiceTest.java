package com.example.exchangeratecalculation.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.example.exchangeratecalculation.domain.Country;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CountryServiceTest {

    @Mock
    private CountryService countryService;

    @DisplayName("국가 목록 가져오기")
    @Test
    void getCurrencies() {
        // given
        when(countryService.find()).thenReturn(Country.currencies());

        // when
        List<Country> currencies = countryService.find();

        // then
        assertThat(currencies).isNotNull();
    }

    @DisplayName("국가 목록 가져오기 - 실패 테스트")
    @Test
    void getCurrencies_fail() {
        // given
        when(countryService.find()).thenReturn(Country.currencies());

        // when
        List<Country> currencies = countryService.find();

        // then
        assertThat(currencies).isNotNull();
    }

}
