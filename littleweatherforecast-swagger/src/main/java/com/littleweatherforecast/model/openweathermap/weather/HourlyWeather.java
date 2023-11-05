package com.littleweatherforecast.model.openweathermap.weather;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class HourlyWeather {
    private Long dt;
    private Double temp;
    private Double feels_like;
    private Integer pressure;
    private Integer humidity;
    private Double dew_point;
    private Double uvi;
    private Integer clouds;
    private Integer visibility;
    private Double wind_speed;
    private Integer wind_deg;
    private Double wind_gust;
    private List<Weather> weather;
    private Integer pop;
}