package com.littleweatherforecast.service.openweathermap;

import com.littleweatherforecast.model.openweathermap.GeocodingResponse;

public class GeocodingApiCall extends ApiCallHelper {
    public GeocodingResponse callApi(String cityName) throws Exception {
        return (GeocodingResponse) super.callApi(String.format(GEOCODING_URL_BASE, cityName), GeocodingResponse.class);
    }
}
