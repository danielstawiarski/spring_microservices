package com.danielstawiarski.currencyexchangeservice.controller;

import com.danielstawiarski.currencyexchangeservice.dto.CurrencyExchangeDTO;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class CurrencyExchangeController {
    public static final String LOCAL_SERVER_PORT = "local.server.port";

    private final Environment environment;

    @GetMapping(value = "/currency-exchange/from/{source}/to/{target}")
    public CurrencyExchangeDTO getCurrencyExchangeRate(@PathVariable String source, @PathVariable String target) {
        return CurrencyExchangeDTO.builder()
                .id(100L)
                .from(source)
                .to(target)
                .conversionMultiple(BigDecimal.ONE)
                .environment(environment.getProperty(LOCAL_SERVER_PORT))
                .build();
    }

}
