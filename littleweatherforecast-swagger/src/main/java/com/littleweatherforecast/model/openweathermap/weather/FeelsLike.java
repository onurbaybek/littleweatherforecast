package com.littleweatherforecast.model.openweathermap.weather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeelsLike{
    private Double day;
    private Double night;
    private Double eve;
    private Double morn;
}