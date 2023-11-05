package com.littleweatherforecast.service;

import com.littleweatherforecast.model.WeatherResponse;
import com.littleweatherforecast.model.openweathermap.GeocodingResponse;
import com.littleweatherforecast.model.openweathermap.WeatherForecastResponse;
import com.littleweatherforecast.model.openweathermap.WeatherInfo;
import com.littleweatherforecast.model.openweathermap.weather.HourlyWeather;
import com.littleweatherforecast.service.openweathermap.GeocodingApiCall;
import com.littleweatherforecast.service.openweathermap.WeatherApiCall;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.TimeZone;

@Service
public class WeatherService {
    public WeatherResponse getWeather(String cityName) throws Exception {
        GeocodingApiCall geocodingCall = new GeocodingApiCall();
        GeocodingResponse geocodingResponse = geocodingCall.callApi(cityName);
        WeatherApiCall weatherApiCall = new WeatherApiCall();
        WeatherForecastResponse weatherForecastResponse = weatherApiCall.callApi(geocodingResponse.getLat(), geocodingResponse.getLon());
        return getResponse(weatherForecastResponse);
    }

    private WeatherResponse getResponse(WeatherForecastResponse weatherForecastResponse) {
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setMaximum(Double.MIN_VALUE);
        weatherResponse.setWeatherInfos(new ArrayList<>());

        for (int i = 0; i < 48; i++) {
            HourlyWeather hourlyWeather = weatherForecastResponse.getHourly().get(i);
            WeatherInfo weatherInfo = new WeatherInfo();
            weatherInfo.setHour(Instant.ofEpochMilli(hourlyWeather.getDt() * 1000).atZone(TimeZone.getDefault().toZoneId()).toLocalDateTime());

            if (hourlyWeather.getTemp() > weatherResponse.getMaximum()) {
                weatherResponse.setMaximum(hourlyWeather.getTemp());
            }

            weatherInfo.setFeelsLikeTemperature(hourlyWeather.getFeels_like());
            weatherInfo.setHumidity(hourlyWeather.getHumidity());
            weatherResponse.getWeatherInfos().add(weatherInfo);
        }

        return weatherResponse;
    }
}
