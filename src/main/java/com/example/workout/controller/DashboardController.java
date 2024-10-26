package com.example.workout.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final Logger log = LoggerFactory.getLogger(DashboardController.class);

    @GetMapping("")
    public String home() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("Current User: {}. Authorities: {}", auth.getName(), auth.getAuthorities());
        List<String> authorities = auth.getAuthorities().stream().map(authority -> authority.toString())
                .collect(Collectors.toList());

        if (authorities.contains("ROLE_ADMIN")) {
            return String.format("Hello admin. Welcome to the Workout Tracker App Dashboard!", auth.getName());
        } else {
            return String.format("Hello %s. Welcome to the Workout Tracker App! Nigger", auth.getName());
        }
    }

}
