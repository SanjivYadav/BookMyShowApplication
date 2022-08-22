package com.design.dtos.Audidtos;

import com.design.models.Auditorium;
import com.design.models.Seat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateSeatResponseDTO {
    private List<Seat> seats;
    private SeatResponseStatusDTO responseStatus;
}
