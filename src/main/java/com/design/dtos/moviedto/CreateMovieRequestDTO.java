package com.design.dtos.moviedto;

import com.design.models.Actor;
import com.design.models.Language;
import com.design.models.MovieFeature;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateMovieRequestDTO {
    private String name;
    private List<Long> actor_ids;
    private List<Language> supportedLanguages;
    private List<MovieFeature> supportedFeatures;
    private int duration;
    private double rating;
}
