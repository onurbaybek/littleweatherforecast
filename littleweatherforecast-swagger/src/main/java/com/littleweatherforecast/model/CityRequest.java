package com.littleweatherforecast.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "City Request model documentation", description = "Model")
@Getter
@Setter
public class CityRequest {
    @ApiModelProperty(value = "City name for retrieving the weather forecast")
    private String name;
}
