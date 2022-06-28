package com.danielstawiarski.currencyexchangeservice.dto;

import com.danielstawiarski.currencyexchangeservice.model.CurrencyExchange;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class CurrencyExchangeDTO {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;

    public static CurrencyExchangeDTO from(CurrencyExchange currencyExchange, String environment) {
        return CurrencyExchangeDTO.builder()
                .id(currencyExchange.getId())
                .from(currencyExchange.getSourceCurrency())
                .to(currencyExchange.getTargetCurrency())
                .conversionMultiple(currencyExchange.getConversionMultiple())
                .environment(environment)
                .build();
    }
}
