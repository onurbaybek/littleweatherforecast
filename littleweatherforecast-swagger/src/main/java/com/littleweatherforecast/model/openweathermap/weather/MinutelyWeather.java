package com.littleweatherforecast.model.openweathermap.weather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MinutelyWeather {
    private Long dt;
    private Integer precipitation;
}