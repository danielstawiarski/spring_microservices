package com.danielstawiarski.currencyconversionservice.controller;

import com.danielstawiarski.currencyconversionservice.dto.CurrencyConversionDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @GetMapping(value = "/currency-conversion/from/{source}/to/{target}/quantity/{quantityValue}")
    public CurrencyConversionDTO calculateCurrencyConversion(
            @PathVariable String source,
            @PathVariable String target,
            @PathVariable BigDecimal quantityValue) {
        return CurrencyConversionDTO.builder()
                .id(100L)
                .conversionMultiple(BigDecimal.ONE)
                .from(source)
                .to(target)
                .quantity(quantityValue)
                .environment("")
                .totalCalculatedAmount(BigDecimal.TEN.multiply(BigDecimal.TEN))
                .build();
    }

}
