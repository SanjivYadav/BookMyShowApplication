package com.design.dtos.userdtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequestDTO {
    private String name;
    private String emailId;
}
