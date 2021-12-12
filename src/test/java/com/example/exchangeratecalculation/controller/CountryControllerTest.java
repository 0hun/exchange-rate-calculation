package com.example.exchangeratecalculation.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.exchangeratecalculation.domain.Country;
import com.example.exchangeratecalculation.service.CountryService;
import com.google.gson.Gson;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CountryController.class)
public class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryService countryService;

    @DisplayName("환율 국가 목록 조회 성공 테스트")
    @Test
    void find() throws Exception {
        // given
        given(countryService.find()).willReturn(Country.currencies());

        // when
        // then
        mockMvc.perform(get("/countries")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json(new Gson().toJson(Country.currencies())))
            .andDo(print());
    }

    @DisplayName("환율 국가 목록 조회 실패 테스트")
    @Test
    void findFail() throws Exception {
        // given
        given(countryService.find()).willThrow(NoSuchElementException.class);

        // when
        // then
        mockMvc.perform(get("/countries")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound())
            .andDo(print());
    }

}
