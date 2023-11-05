package com.littleweatherforecast.service.openweathermap;

import com.littleweatherforecast.model.openweathermap.WeatherForecastResponse;

public class WeatherApiCall extends ApiCallHelper {
    public WeatherForecastResponse callApi(double lat, double lon) throws Exception {
        return (WeatherForecastResponse) callApi(String.format(FOR_NEXT_48_HOURS_WEATHER_URL_BASE, lat, lon), WeatherForecastResponse.class);
    }
}
