package com.design.controllers.moviecontroller;

import com.design.dtos.moviedto.CreateMovieRequestDTO;
import com.design.dtos.moviedto.CreateMovieResponseDTO;
import com.design.dtos.moviedto.MovieResponseStatusDTO;
import com.design.models.Movie;
import com.design.services.movieservice.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService){
        this.movieService =movieService;
    }

    public CreateMovieResponseDTO addMovie(CreateMovieRequestDTO requestDTO) throws Exception {
        Movie generatedMovie = movieService.addMovie(requestDTO.getName(),requestDTO.getActor_ids(),requestDTO.getSupportedLanguages(),
                requestDTO.getSupportedFeatures(),requestDTO.getDuration(),requestDTO.getRating());

        CreateMovieResponseDTO responseDTO = new CreateMovieResponseDTO();
        if(generatedMovie == null){
            responseDTO.setResponseStatusDTO(MovieResponseStatusDTO.FAILURE);
        }
        else{
            responseDTO.setCreatedMovie(generatedMovie);
            responseDTO.setResponseStatusDTO(MovieResponseStatusDTO.SUCESS);
        }
        return responseDTO;
    }
}
