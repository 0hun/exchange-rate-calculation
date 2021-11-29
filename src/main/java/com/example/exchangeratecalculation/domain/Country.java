package com.example.exchangeratecalculation.domain;

import java.util.Arrays;
import java.util.stream.Collectors;
import lombok.Getter;

@Getter
public enum Country {

    KRW("USDKRW", "한국"),

    JPY("USDJPY", "일본"),

    PHP("USDPHP", "필리핀");

    private final String code;

    private final String name;

    Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static Country find(String code) {
       return Arrays.stream(values())
            .filter(country -> country.code.equals(code))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }

    public static String currencies() {
        return Arrays.stream(values())
            .map(country -> country.name())
            .collect(Collectors.joining(","));
    }
}
