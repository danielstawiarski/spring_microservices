package com.danielstawiarski.currencyexchangeservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping(value = "/sample-api")
    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
    public String sampleApi() {
        logger.info("Request to sample api received");
        ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8000/dummy-api", String.class);
        return response.getBody();
    }

    @GetMapping(value = "/sample-api2")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    public String sampleApi2() {
        logger.info("Request to sample api received");
        ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8000/dummy-api", String.class);
        return response.getBody();
    }

    private String hardcodedResponse(Exception exception) {
        return "hardcoded-response";
    }
}
