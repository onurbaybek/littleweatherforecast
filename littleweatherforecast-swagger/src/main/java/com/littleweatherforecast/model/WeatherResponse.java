package com.littleweatherforecast.model;

import com.littleweatherforecast.model.openweathermap.WeatherInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Weather Response model documentation", description = "Model")
@Getter
@Setter
public class WeatherResponse {
    @ApiModelProperty(value = "Maximum temperature forecast")
    private Double maximum;
    @ApiModelProperty(value = "Weather forecast info list for next 48 hours")
    private List<WeatherInfo> weatherInfos;
}
