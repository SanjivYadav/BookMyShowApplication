package com.design;

import com.design.Exception.TheaterNotFoundException;
import com.design.controllers.audicontroller.AuditoriumController;
import com.design.controllers.moviecontroller.MovieController;
import com.design.dtos.Audidtos.CreateAuditoriumRequestDTO;
import com.design.dtos.Audidtos.CreateAuditoriumResponseDTO;
import com.design.dtos.moviedto.CreateMovieRequestDTO;
import com.design.dtos.moviedto.CreateMovieResponseDTO;
import com.design.dtos.moviedto.MovieResponseStatusDTO;
import com.design.models.Actor;
import com.design.models.AuditoriumFeature;
import com.design.models.Language;
import com.design.models.MovieFeature;

import java.util.ArrayList;
import java.util.List;

public class CreateMovieForApp {
    private MovieController movieController;
    public CreateMovieForApp(MovieController movieController){
        this.movieController = movieController;
    }

    public void addMovie() throws Exception {
        CreateMovieRequestDTO requestDTO = new CreateMovieRequestDTO();
        requestDTO.setName("3 idiots");
        requestDTO.setDuration(3);
        requestDTO.setRating(4.2);
        List<Long> actor_ids = new ArrayList<>();
        actor_ids.add(1L);
        requestDTO.setActor_ids(actor_ids);
        List<Language> languages = new ArrayList<>();
        languages.add(Language.ENGLISH);
        languages.add(Language.HINDI);
        requestDTO.setSupportedLanguages(languages);
        List<MovieFeature> movieFeatures = new ArrayList<>();
        movieFeatures.add(MovieFeature.TWO_D);
        movieFeatures.add(MovieFeature.THREE_D);
        requestDTO.setSupportedFeatures(movieFeatures);
        CreateMovieResponseDTO responseDTO = movieController.addMovie(requestDTO);
        if(responseDTO.getResponseStatusDTO().equals(MovieResponseStatusDTO.FAILURE)){
            System.out.println("Something went wrong");
        }
        else {
            System.out.println("Movie Created with id : " + responseDTO.getCreatedMovie().getName());
        }
    }
}
