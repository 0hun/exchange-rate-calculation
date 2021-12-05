package com.example.exchangeratecalculation.infra;

import static com.example.exchangeratecalculation.domain.Country.currencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class CurrencyLayerClient implements CurrencyClient {

    @Value("${current.api.url}")
    private String apiUrl;

    @Value("${current.api.accesskey}")
    private String accessKey;

    @Value("${current.api.source}")
    private String source;

    @Value("${current.api.format}")
    private String format;

    @Override
    public String currentCurrencies() {
        Mono<String> currenciesResponse = createWebClientEntity();

        return currenciesResponse.block();
    }

    private Mono<String> createWebClientEntity() {
        return WebClient.create().get()
            .uri(uriBuilder ->
                uriBuilder.path(apiUrl)
                    .queryParam("access_key", accessKey)
                    .queryParam("currencies", currencies())
                    .queryParam("source", source)
                    .queryParam("format", format)
                    .build()
            ).retrieve()
            .bodyToMono(String.class);
    }
}
