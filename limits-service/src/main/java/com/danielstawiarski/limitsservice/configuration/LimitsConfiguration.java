package com.danielstawiarski.limitsservice.configuration;


import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "limits-service")
@Setter
@Getter
@NoArgsConstructor
public class LimitsConfiguration {
    private int minimum;
    private int maximum;
}