package com.example.openweatherservice.exception;

public record Error(
        String code,
        String type,
        String info
) {
}
