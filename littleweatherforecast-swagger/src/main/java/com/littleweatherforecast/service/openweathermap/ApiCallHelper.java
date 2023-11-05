package com.littleweatherforecast.service.openweathermap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.littleweatherforecast.model.openweathermap.OpenWeatherMapResponse;
import com.littleweatherforecast.model.openweathermap.WeatherHttpURLConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public abstract class ApiCallHelper implements ApiCall {
    private static final String URL_BASE = "http://api.openweathermap.org/";
    private static final String APP_ID = "dbb555bea537b2352d62b77633ba1292";
    protected static final String GEOCODING_URL_BASE = String.join("", URL_BASE, "geo/1.0/direct?q=%s&limit=1&appid=", APP_ID);
    protected static final String FOR_NEXT_48_HOURS_WEATHER_URL_BASE = String.join("", URL_BASE, "data/3.0/onecall?lat=%f&lon=%f&units=metric&appid=", APP_ID);

    @Override
    public OpenWeatherMapResponse callApi(String url, Class<?> target) throws Exception {
        URL requestUrl = new URL(url);
        String response = getResponse(executeRequest(requestUrl));
        List<OpenWeatherMapResponse> responses = getResponseObject(response, target);
        return responses.get(0);
    }

    public static String getResponse(InputStream response) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(response));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content.toString();
    }

    private static <T> T getResponseObject(String responseContent, Class<?> target) throws JsonParseException, JsonMappingException, IOException, ClassNotFoundException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        return objectMapper.readValue(responseContent, objectMapper.getTypeFactory().constructCollectionType(List.class, Class.forName(target.getName())));
    }

    private static InputStream executeRequest(URL requestUrl) {
        InputStream resultStream;

        try {
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("GET");

            switch (connection.getResponseCode()) {
                case WeatherHttpURLConnection.HTTP_OK:
                    return connection.getInputStream();
                case WeatherHttpURLConnection.HTTP_BAD_REQUEST:
                    throw new Exception("HTTP_BAD_REQUEST 400");
                case WeatherHttpURLConnection.HTTP_UNAUTHORIZED:
                    throw new Exception("HTTP_UNAUTHORIZED 401");
                case WeatherHttpURLConnection.HTTP_NOT_FOUND:
                    throw new Exception("HTTP_NOT_FOUND 404");
                case WeatherHttpURLConnection.HTTP_TOO_MANY_REQUESTS:
                    throw new Exception("HTTP_TOO_MANY_REQUESTS 429");
                default:
                    throw new IllegalStateException("Unexpected value: " + connection.getResponseCode());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
