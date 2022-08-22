package com.design.dtos.theaterdtos;

import com.design.models.Theater;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTheaterResponseDTO {
    private Theater theater;
    private TheaterResponseStatusDTO responseStatusDTO;
}
