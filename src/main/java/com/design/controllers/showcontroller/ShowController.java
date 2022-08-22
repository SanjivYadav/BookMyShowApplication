package com.design.controllers.showcontroller;

import com.design.Exception.AuditoriumNotFoundException;
import com.design.Exception.MovieNotFoundException;
import com.design.dtos.showdto.CreateShowRequestDTO;
import com.design.dtos.showdto.CreateShowResponseDTO;
import com.design.dtos.showdto.ShowResponseStatusDTO;
import com.design.models.Show;
import com.design.services.showservice.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ShowController {
    private final ShowService showService;

    @Autowired
    public ShowController(ShowService showService){
        this.showService = showService;
    }

    public CreateShowResponseDTO addShow(CreateShowRequestDTO requestDTO) throws MovieNotFoundException, AuditoriumNotFoundException {
        Show createdShow = showService.addShow(requestDTO.getMovie_Id(),
                requestDTO.getAuditorium_Id(),
                requestDTO.getStart_time(),
                requestDTO.getEnd_time(),
                requestDTO.getShowFeatures(),
                requestDTO.getShowSeatTypePrice());

        CreateShowResponseDTO responseDTO = new CreateShowResponseDTO();
        responseDTO.setCreatedShow(createdShow);
        responseDTO.setResponseStatusDTO(ShowResponseStatusDTO.SUCESS);
        return responseDTO;
    }
}
