package com.example.openweatherservice.service;

import com.example.openweatherservice.dto.WeatherResponse;
import com.example.openweatherservice.model.Weather;
import com.example.openweatherservice.repository.WeatherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.example.openweatherservice.constants.WeatherConstants.*;

@Service
@CacheConfig(cacheNames = {"weathers"})
public class WeatherService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherService.class);

    private final WeatherRepository weatherRepository;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Clock clock;

    public WeatherService(WeatherRepository weatherRepository, RestTemplate restTemplate, Clock clock) {
        this.weatherRepository = weatherRepository;
        this.restTemplate = restTemplate;
        this.clock = clock;
    }

    private Weather saveWeather(String city, WeatherResponse response){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Weather weather = new Weather(city,
                response.location().name(),
                response.location().country(),
                response.current().temperature(),
                getLocalDateTime(),
                LocalDateTime.parse(response.location().localtime(),formatter));

        return weatherRepository.save(weather);
    }

    private String getWeatherStackUrl(String city){
        String service = WEATHER_STACK_API_BASE_URL + WEATHER_STACK_API_ACCESS_KEY_PARAM + API_KEY + WEATHER_STACK_API_QUERY_PARAM + city;
        LOGGER.info("Calling service ", service);
        return service;
    }

    private LocalDateTime getLocalDateTime() {
        Instant instant = clock.instant();
        return LocalDateTime.ofInstant(
                instant,
                Clock.systemDefaultZone().getZone()
        );
    }
}
