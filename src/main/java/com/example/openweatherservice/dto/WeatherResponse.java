package com.example.openweatherservice.dto;

public record WeatherResponse(
        WeatherRequest request,
        Location location,
        Current current
) { }
