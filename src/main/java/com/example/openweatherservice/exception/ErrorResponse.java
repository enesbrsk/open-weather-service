package com.example.openweatherservice.exception;

public record ErrorResponse(
        String success,
        Error error
) {
}
