package com.example.openweatherservice.dto;

public record WeatherRequest(
        String type,
        String query,
        String language,
        String unit
) {}
