package com.littleweatherforecast.model.openweathermap;

import com.littleweatherforecast.model.openweathermap.weather.CurrentWeather;
import com.littleweatherforecast.model.openweathermap.weather.DailyWeather;
import com.littleweatherforecast.model.openweathermap.weather.HourlyWeather;
import com.littleweatherforecast.model.openweathermap.weather.MinutelyWeather;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WeatherForecastResponse extends OpenWeatherMapResponse {
    private Double lat;
    private Double lon;
    private String timezone;
    private Integer timezone_offset;
    private CurrentWeather current;
    private List<MinutelyWeather> minutely;
    private List<HourlyWeather> hourly;
    private List<DailyWeather> daily;
}