package com.example.openweatherservice.repository;

import com.example.openweatherservice.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WeatherRepository extends JpaRepository<Weather,Long> {
    Optional<Weather> findFirstByRequestedCityNameOrderByUpdatedTimeDesc(String city);
}
