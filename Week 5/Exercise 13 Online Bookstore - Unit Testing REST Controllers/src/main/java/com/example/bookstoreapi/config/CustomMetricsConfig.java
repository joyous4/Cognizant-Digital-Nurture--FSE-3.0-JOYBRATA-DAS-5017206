package com.example.bookstoreapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.MeterRegistry;

//CustomMetricsConfig class added to define a bean for Custom Metrics as required by Excercise 11
@Configuration
public class CustomMetricsConfig {

    @Autowired
    public CustomMetricsConfig(MeterRegistry meterRegistry) {
        meterRegistry.counter("book.created.count").increment(0); 
    }
}
