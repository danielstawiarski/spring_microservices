package com.danielstawiarski.currencyconversionservice.proxy;

import com.danielstawiarski.currencyconversionservice.dto.CurrencyConversionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    @GetMapping(value = "/currency-exchange/from/{source}/to/{target}")
    CurrencyConversionDTO getCurrencyExchangeRate(@PathVariable String source, @PathVariable String target);
}
