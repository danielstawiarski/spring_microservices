package com.danielstawiarski.currencyexchangeservice.controller;

import com.danielstawiarski.currencyexchangeservice.dto.CurrencyExchangeDTO;
import com.danielstawiarski.currencyexchangeservice.model.CurrencyExchange;
import com.danielstawiarski.currencyexchangeservice.repository.CurrencyExchangeRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CurrencyExchangeController {
    public static final String LOCAL_SERVER_PORT = "local.server.port";

    private final CurrencyExchangeRepository currencyExchangeRepository;
    private final Environment environment;

    @GetMapping(value = "/currency-exchange/from/{source}/to/{target}")
    public CurrencyExchangeDTO getCurrencyExchangeRate(@PathVariable String source, @PathVariable String target) {
        CurrencyExchange foundRate = currencyExchangeRepository.findAllBySourceCurrencyAndTargetCurrency(source, target)
                .orElseThrow(() ->
                        new IllegalArgumentException("Cannot find currency exchange rate for " + source  + " to " + target));

        return CurrencyExchangeDTO.from(foundRate, environment.getProperty(LOCAL_SERVER_PORT));
    }

}
