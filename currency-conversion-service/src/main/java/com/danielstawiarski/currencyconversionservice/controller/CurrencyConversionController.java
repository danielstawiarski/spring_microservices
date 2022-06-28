package com.danielstawiarski.currencyconversionservice.controller;

import com.danielstawiarski.currencyconversionservice.dto.CurrencyConversionDTO;
import com.danielstawiarski.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class CurrencyConversionController {

    private final RestTemplate restTemplate;
    private final CurrencyExchangeServiceProxy exchangeServiceProxy;

    @GetMapping(value = "/currency-conversion/from/{source}/to/{target}/quantity/{quantityValue}")
    public CurrencyConversionDTO calculateCurrencyConversion(
            @PathVariable String source,
            @PathVariable String target,
            @PathVariable BigDecimal quantityValue) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("source", source);
        uriVariables.put("target", target);

        CurrencyConversionDTO response
                = restTemplate.getForEntity("http://localhost:8000/currency-exchange/from/{source}/to/{target}",
                CurrencyConversionDTO.class, uriVariables).getBody();

        return CurrencyConversionDTO.builder()
                .id(response.getId())
                .conversionMultiple(response.getConversionMultiple())
                .from(source)
                .to(target)
                .quantity(quantityValue)
                .environment(response.getEnvironment())
                .totalCalculatedAmount(quantityValue.multiply(response.getConversionMultiple()))
                .build();
    }

    @GetMapping(value = "/currency-conversion-feign/from/{source}/to/{target}/quantity/{quantityValue}")
    public CurrencyConversionDTO calculateCurrencyConversionFeign(
            @PathVariable String source,
            @PathVariable String target,
            @PathVariable BigDecimal quantityValue) {
        CurrencyConversionDTO response = exchangeServiceProxy.getCurrencyExchangeRate(source, target);
        return CurrencyConversionDTO.builder()
                .id(response.getId())
                .conversionMultiple(response.getConversionMultiple())
                .from(source)
                .to(target)
                .quantity(quantityValue)
                .environment(response.getEnvironment())
                .totalCalculatedAmount(quantityValue.multiply(response.getConversionMultiple()))
                .build();
    }
}
