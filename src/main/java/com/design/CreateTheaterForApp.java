package com.design;

import com.design.Exception.CityNotFoundException;
import com.design.controllers.theatercontroller.TheaterController;
import com.design.controllers.usercontroller.UserController;
import com.design.dtos.theaterdtos.CreateTheaterResponseDTO;
import com.design.dtos.theaterdtos.CreateTheatorRequestDTO;
import com.design.dtos.userdtos.CreateUserRequestDTO;
import com.design.dtos.userdtos.CreateUserResponseDTO;
import com.design.dtos.userdtos.ResponseStatusDTO;

public class CreateTheaterForApp {

    private TheaterController theaterController;
    public CreateTheaterForApp(TheaterController theaterController){
        this.theaterController = theaterController;
    }

    public void addTheater() throws CityNotFoundException {
        CreateTheatorRequestDTO requestDTO = new CreateTheatorRequestDTO();
        requestDTO.setName("PVR");
        requestDTO.setAddress("132,gurgaon");
        requestDTO.setCityId(1L);
        CreateTheaterResponseDTO responseDTO = theaterController.addTheater(requestDTO);
        System.out.println("Theater Created with name : "+responseDTO.getTheater().getName());
    }
}
