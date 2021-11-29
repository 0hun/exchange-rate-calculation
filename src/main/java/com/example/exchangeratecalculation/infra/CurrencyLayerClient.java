package com.example.exchangeratecalculation.infra;

import static com.example.exchangeratecalculation.domain.Country.currencies;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class CurrencyLayerClient implements CurrencyClient {

    private static String API_URL = "apilayer.net/api/live";

    private static String ACCESS_KEY = "0316b184353714829e79360266352c54";

    private static String SOURCE = "USD";

    private static int FORMAT = 1;

    @Override
    public String currentCurrencies() {
        Mono<String> currenciesResponse = createWebClientEntity();

        return currenciesResponse.block();
    }

    private Mono<String> createWebClientEntity() {
        return WebClient.create().get()
            .uri(uriBuilder ->
                uriBuilder.path(API_URL)
                    .queryParam("access_key", ACCESS_KEY)
                    .queryParam("currencies", currencies())
                    .queryParam("source", SOURCE)
                    .queryParam("format", FORMAT)
                    .build()
            ).retrieve()
            .bodyToMono(String.class);
    }
}
