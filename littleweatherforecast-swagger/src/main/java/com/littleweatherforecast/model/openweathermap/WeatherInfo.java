package com.littleweatherforecast.model.openweathermap;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Weather Info model documentation", description = "Model")
@Getter
@Setter
public class WeatherInfo {
    @ApiModelProperty(value = "Weather forecast hour")
    private LocalDateTime hour;
    @ApiModelProperty(value = "Felt temperature")
    private Double feelsLikeTemperature;
    @ApiModelProperty(value = "Humidity")
    private Integer humidity;
}
