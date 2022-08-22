package com.design.dtos.theaterdtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTheatorRequestDTO {
    private String name;
    private String address;
    private Long cityId;
}
