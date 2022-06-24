package com.danielstawiarski.limitsservice.dto;

import com.danielstawiarski.limitsservice.configuration.LimitsConfiguration;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Value
public class Limits {
    int minimum;
    int maximum;

    public static Limits from(LimitsConfiguration configuration) {
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }
}
