package com.danielstawiarski.limitsservice.controller;

import com.danielstawiarski.limitsservice.configuration.LimitsConfiguration;
import com.danielstawiarski.limitsservice.dto.Limits;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LimitsController {

    private final LimitsConfiguration configuration;

    @GetMapping("/limits")
    public Limits getLimits() {
        return Limits.from(configuration);
    }
}
