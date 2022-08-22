package com.design.dtos.citydtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCityResponseDTO {
    private String name;
    private Long id;
    private CityResponseStatus responseStatus;
}
