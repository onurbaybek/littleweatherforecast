package com.littleweatherforecast.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {
    @Mock
    private WeatherService weatherService;

    @Test
    void given_city_London_when_weatherService_then_valid() throws Exception {
        weatherService.getWeather("London");
        Mockito.verify(weatherService, Mockito.times(1)).getWeather("London");
    }

}