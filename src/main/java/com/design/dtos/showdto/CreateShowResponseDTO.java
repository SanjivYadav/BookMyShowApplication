package com.design.dtos.showdto;

import com.design.models.Movie;
import com.design.models.Show;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateShowResponseDTO {
    private Show createdShow;
    private ShowResponseStatusDTO responseStatusDTO;
}
