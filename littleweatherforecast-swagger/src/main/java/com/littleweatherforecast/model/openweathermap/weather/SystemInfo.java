package com.littleweatherforecast.model.openweathermap.weather;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SystemInfo {
    private Integer type;
    private Long id;
    private String country;
    private LocalDateTime sunrise;
    private LocalDateTime sunset;
}
