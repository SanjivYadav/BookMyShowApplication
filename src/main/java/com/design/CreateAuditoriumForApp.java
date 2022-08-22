package com.design;

import com.design.Exception.AuditoriumNotFoundException;
import com.design.Exception.CityNotFoundException;
import com.design.Exception.TheaterNotFoundException;
import com.design.controllers.audicontroller.AuditoriumController;
import com.design.controllers.theatercontroller.TheaterController;
import com.design.dtos.Audidtos.CreateAuditoriumRequestDTO;
import com.design.dtos.Audidtos.CreateAuditoriumResponseDTO;
import com.design.dtos.Audidtos.CreateSeatRequestDTO;
import com.design.dtos.Audidtos.CreateSeatResponseDTO;
import com.design.dtos.theaterdtos.CreateTheaterResponseDTO;
import com.design.dtos.theaterdtos.CreateTheatorRequestDTO;
import com.design.models.AuditoriumFeature;
import com.design.models.SeatType;
import com.design.models.Theater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateAuditoriumForApp {
    private AuditoriumController auditoriumController;
    public CreateAuditoriumForApp(AuditoriumController auditoriumController){
        this.auditoriumController = auditoriumController;
    }

    public void addAuditorium() throws TheaterNotFoundException {
        CreateAuditoriumRequestDTO requestDTO = new CreateAuditoriumRequestDTO();
        requestDTO.setAudi_no(9965234);
        requestDTO.setCapacity(50);
        requestDTO.setTheaterId(1L);
        List<AuditoriumFeature> auditoriumFeatures = new ArrayList<>();
        auditoriumFeatures.add(AuditoriumFeature.TWO_D);
        auditoriumFeatures.add(AuditoriumFeature.THREE_D);
        requestDTO.setAuditoriumFeatureList(auditoriumFeatures);
        CreateAuditoriumResponseDTO responseDTO = auditoriumController.addAuditorium(requestDTO);
        System.out.println("Auditorium Created with id : " + responseDTO.getAuditorium().getAnudi_no());
    }

    public void addSeats() throws AuditoriumNotFoundException {
        CreateSeatRequestDTO requestDTO = new CreateSeatRequestDTO();
        requestDTO.setAuditorium_Id(1L);
        Map<SeatType, Integer> seatTypeCount = new HashMap<>();
        seatTypeCount.put(SeatType.GOLD, 25);
        seatTypeCount.put(SeatType.SILVER,15);
        seatTypeCount.put(SeatType.VIP,10);
        requestDTO.setSeatTypes(seatTypeCount);
        CreateSeatResponseDTO responseDTO = auditoriumController.addSeats(requestDTO);
        System.out.println("Seats Created with Status : " + responseDTO.getResponseStatus());
    }
}
