package com.design.controllers.citycontroller;

import com.design.dtos.citydtos.CityResponseStatus;
import com.design.dtos.citydtos.CreateCityRequestDTO;
import com.design.dtos.citydtos.CreateCityResponseDTO;
import com.design.models.City;
import com.design.services.cityservice.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    public CreateCityResponseDTO createCity(CreateCityRequestDTO requestDTO){
        City createdCity = cityService.createCity(requestDTO.getName());

        CreateCityResponseDTO responseDTO = new CreateCityResponseDTO();
        if(createdCity == null){
            responseDTO.setResponseStatus(CityResponseStatus.FAILED);
            return responseDTO;
        }
        responseDTO.setName(createdCity.getName());
        responseDTO.setId(createdCity.getId());
        responseDTO.setResponseStatus(CityResponseStatus.SUCCESS);
        return responseDTO;
    }
}
