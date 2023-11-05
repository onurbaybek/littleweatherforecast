package com.littleweatherforecast.controller;

import com.littleweatherforecast.model.CityRequest;
import com.littleweatherforecast.model.WeatherResponse;
import com.littleweatherforecast.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@Api(value = "Weather Api documentation")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping
    @ApiOperation(value = "Retrieves weather by city name")
    public ResponseEntity<WeatherResponse> get(@RequestBody CityRequest city) throws Exception {
        return ResponseEntity.ok(weatherService.getWeather(city.getName()));
    }
}
