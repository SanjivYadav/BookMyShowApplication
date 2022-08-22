package com.design;

import com.design.controllers.citycontroller.CityController;
import com.design.controllers.usercontroller.UserController;
import com.design.dtos.citydtos.CityResponseStatus;
import com.design.dtos.citydtos.CreateCityRequestDTO;
import com.design.dtos.citydtos.CreateCityResponseDTO;
import com.design.dtos.userdtos.CreateUserRequestDTO;
import com.design.dtos.userdtos.CreateUserResponseDTO;
import com.design.dtos.userdtos.ResponseStatusDTO;

public class CreateCityForApp {

    private final CityController cityController;
    public CreateCityForApp(CityController cityController){
        this.cityController = cityController;
    }

    public void createCity(){
        CreateCityRequestDTO requestDTO = new CreateCityRequestDTO();
        requestDTO.setName("Lucknow");
        CreateCityResponseDTO responseDTO = cityController.createCity(requestDTO);
        if(responseDTO.getResponseStatus().equals(CityResponseStatus.FAILED)){
            System.out.println("Something went wrong while creating the city");
        }
        else{
            System.out.println("City Created with name : "+responseDTO.getName());
        }
    }

}
