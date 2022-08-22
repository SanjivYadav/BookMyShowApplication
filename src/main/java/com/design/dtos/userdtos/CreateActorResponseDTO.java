package com.design.dtos.userdtos;

import com.design.models.Actor;
import com.design.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateActorResponseDTO {
    private Actor actor;
    private ResponseStatusDTO responseStatusDTO;
}
