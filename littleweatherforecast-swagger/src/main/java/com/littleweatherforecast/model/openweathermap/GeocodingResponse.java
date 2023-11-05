package com.littleweatherforecast.model.openweathermap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class GeocodingResponse extends OpenWeatherMapResponse {
    private String name;
    @JsonIgnoreProperties(ignoreUnknown=true)
    private List<Language> local_names;
    private Double lat;
    private Double lon;
    private String country;
    private String state;
}
