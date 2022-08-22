package com.design.controllers.audicontroller;

import com.design.Exception.AuditoriumNotFoundException;
import com.design.Exception.TheaterNotFoundException;
import com.design.dtos.Audidtos.*;
import com.design.models.Auditorium;
import com.design.models.Seat;
import com.design.models.SeatType;
import com.design.services.auditoriumservice.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuditoriumController {
    private AuditoriumService auditoriumService;

    @Autowired
    public AuditoriumController(AuditoriumService auditoriumService){
        this.auditoriumService = auditoriumService;
    }

    public CreateAuditoriumResponseDTO addAuditorium(CreateAuditoriumRequestDTO requestDTO) throws TheaterNotFoundException {
        Auditorium auditorium = auditoriumService.addAuditorium(requestDTO.getAudi_no(), requestDTO.getCapacity(),
                requestDTO.getAuditoriumFeatureList(), requestDTO.getTheaterId());
        CreateAuditoriumResponseDTO responseDTO = new CreateAuditoriumResponseDTO();
        responseDTO.setAuditorium(auditorium);
        responseDTO.setResponseStatus(AuditoriumResponseStatusDTO.SUCCESS);
        return responseDTO;
    }

    public CreateSeatResponseDTO addSeats(CreateSeatRequestDTO requestDTO) throws AuditoriumNotFoundException {
        List<Seat> createdSeats = auditoriumService.addSeats(requestDTO.getAuditorium_Id(),requestDTO.getSeatTypes());

        CreateSeatResponseDTO responseDTO = new CreateSeatResponseDTO();
        responseDTO.setSeats(createdSeats);
        responseDTO.setResponseStatus(SeatResponseStatusDTO.SUCCESS);
        return responseDTO;
    }
}
