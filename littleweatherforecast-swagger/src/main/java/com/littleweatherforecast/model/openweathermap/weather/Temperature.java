package com.littleweatherforecast.model.openweathermap.weather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Temperature {
    private Double day;
    private Double min;
    private Double max;
    private Double night;
    private Double eve;
    private Double morn;
}