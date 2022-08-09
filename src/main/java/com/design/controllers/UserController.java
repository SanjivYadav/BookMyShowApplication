package com.design.controller;

import com.design.dtos.CreateUserRequestDTO;
import com.design.dtos.CreateUserResponseDTO;
import com.design.dtos.ResponseStatusDTO;
import com.design.model.User;
import com.design.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    public CreateUserResponseDTO createUser(CreateUserRequestDTO requestDTO){
        User createdUSer = userService.createUser(requestDTO.getName(), requestDTO.getEmailId());
        CreateUserResponseDTO responseDTO = new CreateUserResponseDTO();
        responseDTO.setUser(createdUSer);
        responseDTO.setResponseStatusDTO(ResponseStatusDTO.SUCCESS);
        return responseDTO;
    }
}
