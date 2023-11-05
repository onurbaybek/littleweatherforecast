# Little Weather Forecast Documentation

This application runs with Spring Boot. The application uses OpenWeatherAPIs.

In the application, the maximum temperature, felt temperatures and humidity values for the next 48 hours can be obtained.

The application first finds the geographical information of the city. Then,OpenWeatherAPIs are called using geographical information.  

## Request Content
```javascript
City Request model documentation {
    description:        Model
    name                string
                        City name for retrieving the weather forecast
}
```


## Response Content
```javascript
Weather Response model documentation{
  description:          Model
  maximum               number($double)
                        Maximum temperature forecast
  weatherInfos          [
                        Weather forecast info list for next 48 hours
                        Weather Info model documentation{
                            description:            Model
                            feelsLikeTemperature    number($double)
                                                    Felt temperature
                            hour                    string($date-time)
                                                    Weather forecast hour
                            humidity                integer($int32)
                                                    Humidity
  }]
}
```

## Open the application with Swagger;
* After run the project,http://localhost:8080/swagger-ui.html#/weather-controller opens in the browser.
* The name of the city is entered.
* Execute button is clicked.

