package com.design;

import com.design.controllers.moviecontroller.MovieController;
import com.design.controllers.showcontroller.ShowController;
import com.design.dtos.moviedto.CreateMovieRequestDTO;
import com.design.dtos.moviedto.CreateMovieResponseDTO;
import com.design.dtos.moviedto.MovieResponseStatusDTO;
import com.design.dtos.showdto.CreateShowRequestDTO;
import com.design.dtos.showdto.CreateShowResponseDTO;
import com.design.dtos.showdto.ShowResponseStatusDTO;
import com.design.models.Language;
import com.design.models.MovieFeature;
import com.design.models.SeatType;
import com.design.models.ShowFeature;

import java.util.*;

public class CreateShowForApp {
    private ShowController showController;
    public CreateShowForApp(ShowController showController){
        this.showController = showController;
    }

    public void addShow() throws Exception {
        CreateShowRequestDTO requestDTO = new CreateShowRequestDTO();
        requestDTO.setMovie_Id(1L);
        requestDTO.setAuditorium_Id(1L);
        ArrayList<ShowFeature> showFeatures =new ArrayList<>();
        showFeatures.add(ShowFeature.THREE_D);
        showFeatures.add(ShowFeature.TWO_D);
        requestDTO.setShowFeatures(showFeatures);
        requestDTO.setStart_time(new Date());
        requestDTO.setEnd_time(new Date());
        Map<SeatType,Double> showSeatTypePrice = new HashMap<>();
        showSeatTypePrice.put(SeatType.GOLD, 200.00);
        showSeatTypePrice.put(SeatType.SILVER, 250.00);
        showSeatTypePrice.put(SeatType.VIP, 400.00);
        requestDTO.setShowSeatTypePrice(showSeatTypePrice);
        CreateShowResponseDTO responseDTO = showController.addShow(requestDTO);
        if(responseDTO.getResponseStatusDTO().equals(ShowResponseStatusDTO.FAILURE)){
            System.out.println("Something went wrong");
        }
        else {
            System.out.println("Show Created with id : " + responseDTO.getCreatedShow().getId());
        }
    }
}
