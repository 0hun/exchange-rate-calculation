package com.example.exchangeratecalculation.controller;

import com.example.exchangeratecalculation.domain.Country;
import com.example.exchangeratecalculation.service.CountryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/countries")
@RequiredArgsConstructor // 초기화 되지 않은 final field에 대해 생성자를 생성. final field에 의존성 주입
@RestController
public class CountryController {

    private final CountryService countryService;

    @GetMapping()
    public ResponseEntity<List<Country>> find() {
        List<Country> countries = countryService.find();

        return ResponseEntity.ok(countries);
    }

}
