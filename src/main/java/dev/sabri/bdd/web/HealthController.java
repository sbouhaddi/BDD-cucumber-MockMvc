package dev.sabri.bdd.web;

import org.springframework.boot.actuate.health.Health;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public record HealthController() {

    @GetMapping("/health")
    public Health getHealth() {
        return Health.up().build();
    }
}
