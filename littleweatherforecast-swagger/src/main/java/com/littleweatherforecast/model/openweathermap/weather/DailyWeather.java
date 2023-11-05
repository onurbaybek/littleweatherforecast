package com.littleweatherforecast.model.openweathermap.weather;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DailyWeather {
    private Long dt;
    private Long sunrise;
    private Long sunset;
    private Long moonrise;
    private Long moonset;
    private Double moon_phase;
    private String summary;
    private Temperature temp;
    private FeelsLike feels_like;
    private Integer pressure;
    private Integer humidity;
    private Double dew_point;
    private Double wind_speed;
    private Integer wind_deg;
    private Double wind_gust;
    private List<Weather> weather;
    private Integer clouds;
    private Integer pop;
    private Double rain;
    private Double uvi;
}