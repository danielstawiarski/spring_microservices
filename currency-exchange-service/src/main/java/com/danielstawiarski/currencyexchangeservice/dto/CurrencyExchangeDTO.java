package com.danielstawiarski.currencyexchangeservice.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class CurrencyExchangeDTO {
    private long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;
}
