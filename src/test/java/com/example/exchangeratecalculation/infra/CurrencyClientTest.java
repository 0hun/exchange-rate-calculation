package com.example.exchangeratecalculation.infra;

import static org.assertj.core.api.Assertions.assertThat;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CurrencyLayerClient.class, properties = "classpath:application.properties")
public class CurrencyClientTest {

    @Autowired
    CurrencyClient currencyClient;

    @DisplayName("국가별 환율 가져오기")
    @Test
    void getCurrentCurrencies() throws Exception{
        // given
        JSONParser parser = new JSONParser();

        // when
        String result = currencyClient.currentCurrencies();
        JSONObject jsonObj = (JSONObject) parser.parse(result);
        boolean isSuccess = (boolean) jsonObj.get("success");

        // then
        assertThat(isSuccess).isTrue();
    }

}
