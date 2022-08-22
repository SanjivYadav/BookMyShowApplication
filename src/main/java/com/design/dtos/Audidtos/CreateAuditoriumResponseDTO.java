package com.design.dtos.Audidtos;

import com.design.models.Auditorium;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAuditoriumResponseDTO {
    private Auditorium auditorium;
    private AuditoriumResponseStatusDTO responseStatus;
}
