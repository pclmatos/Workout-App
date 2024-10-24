package com.example.workout.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequestLoggingInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        logger.info("Incoming Request: method={}, URI={}", request.getMethod(), request.getRequestURI());

        request.getParameterMap().forEach((name, val) -> logger.info("{}={}", name, val));
        return true; // Continue with request handling
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        logger.info("Request Completed: method={}, URI={}, Status={}",
                request.getMethod(),
                request.getRequestURI(),
                response.getStatus());
    }
}
