package com.littleweatherforecast.model.openweathermap.weather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainInfo {
    private Double temp;
    private Double feels_like;
    private Double temp_min;
    private Double temp_max;
    private Double pressure;
    private Integer humidity;
}
