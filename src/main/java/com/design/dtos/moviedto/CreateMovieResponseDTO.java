package com.design.dtos.moviedto;

import com.design.models.Movie;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMovieResponseDTO {
    private Movie createdMovie;
    private MovieResponseStatusDTO responseStatusDTO;
}
