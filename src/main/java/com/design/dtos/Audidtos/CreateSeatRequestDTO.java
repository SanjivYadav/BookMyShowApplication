package com.design.dtos.Audidtos;

import com.design.models.AuditoriumFeature;
import com.design.models.SeatType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class CreateSeatRequestDTO {
    private Long auditorium_Id;
    private Map<SeatType, Integer> seatTypes;

}
