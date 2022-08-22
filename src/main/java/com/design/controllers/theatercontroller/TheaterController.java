package com.design.controllers.theatercontroller;

import com.design.Exception.CityNotFoundException;
import com.design.dtos.theaterdtos.CreateTheatorRequestDTO;
import com.design.dtos.theaterdtos.CreateTheaterResponseDTO;
import com.design.dtos.theaterdtos.TheaterResponseStatusDTO;
import com.design.models.Theater;
import com.design.services.theaterservice.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TheaterController {

    private TheaterService theaterService;

    @Autowired
    public TheaterController(TheaterService theaterService){
        this.theaterService = theaterService;
    }

    public CreateTheaterResponseDTO addTheater(CreateTheatorRequestDTO requestDTO) throws CityNotFoundException {
        Theater createdTheater = theaterService.addTheater(requestDTO.getName(), requestDTO.getAddress(), requestDTO.getCityId());
        CreateTheaterResponseDTO responseDTO = new CreateTheaterResponseDTO();
        if(createdTheater == null){
            responseDTO.setResponseStatusDTO(TheaterResponseStatusDTO.FAILURE);
            return responseDTO;
        }
        responseDTO.setTheater(createdTheater);
        responseDTO.setResponseStatusDTO(TheaterResponseStatusDTO.SUCCESS);
        return responseDTO;
    }
}
