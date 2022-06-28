package com.danielstawiarski.currencyexchangeservice.repository;

import com.danielstawiarski.currencyexchangeservice.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    Optional<CurrencyExchange> findAllBySourceCurrencyAndTargetCurrency(String source, String target);
}
