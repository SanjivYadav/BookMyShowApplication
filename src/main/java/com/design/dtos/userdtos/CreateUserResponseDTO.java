package com.design.dtos.userdtos;

import com.design.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserResponseDTO {
    private User user;
    private ResponseStatusDTO responseStatusDTO;
}
