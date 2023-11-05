package com.littleweatherforecast.model.openweathermap;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherHttpURLConnection extends HttpURLConnection {
    /**
     * HTTP Status-Code 429: Not Found.
     */
    public static final int HTTP_TOO_MANY_REQUESTS = 429;

    /**
     * Constructor for the HttpURLConnection.
     *
     * @param u the URL
     */
    protected WeatherHttpURLConnection(URL u) {
        super(u);
    }

    @Override
    public void disconnect() {
    }

    @Override
    public boolean usingProxy() {
        return false;
    }

    @Override
    public void connect() throws IOException {

    }
}
