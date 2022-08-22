package com.design.dtos.Audidtos;

import com.design.models.AuditoriumFeature;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateAuditoriumRequestDTO {
    private int audi_no;
    private int capacity;
    private Long theaterId;
    private List<AuditoriumFeature> auditoriumFeatureList;

}
