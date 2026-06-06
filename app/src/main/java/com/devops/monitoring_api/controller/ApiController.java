package com.devops.monitoring_api.controller;


import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final Counter requestCounter;

    public ApiController(MeterRegistry registry) {
        this.requestCounter = Counter.builder("api_requests_total")
                .description("Total number of API requests")
                .tag("endpoint", "status")
                .register(registry);
    }

    @GetMapping("/status")
    public Map<String, Object> getStatus() {
        requestCounter.increment();

        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "monitoring-api");
        response.put("timestamp", System.currentTimeMillis());
        return response;
    }

    @GetMapping("/metrics/summary")
    public Map<String, Object> getMetricsSummary() {
        Runtime runtime = Runtime.getRuntime();

        Map<String, Object> metrics = new HashMap<>();
        metrics.put("heap_used_mb", (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024);
        metrics.put("heap_max_mb", runtime.maxMemory() / 1024 / 1024);
        metrics.put("available_processors", runtime.availableProcessors());
        metrics.put("timestamp", System.currentTimeMillis());
        return metrics;
    }
}
