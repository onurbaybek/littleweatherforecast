package com.littleweatherforecast.service.openweathermap;

import com.littleweatherforecast.model.openweathermap.OpenWeatherMapResponse;

public interface ApiCall {
    OpenWeatherMapResponse callApi(String url, Class<?> target) throws Exception;
}
