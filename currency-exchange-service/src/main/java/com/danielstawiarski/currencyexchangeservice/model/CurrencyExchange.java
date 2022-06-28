package com.danielstawiarski.currencyexchangeservice.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
public class CurrencyExchange {
    @Id
    private Long id;
    private String sourceCurrency;
    private String targetCurrency;
    private BigDecimal conversionMultiple;
}
