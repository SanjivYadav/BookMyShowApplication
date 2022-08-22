package com.design.controllers.usercontroller;


import com.design.dtos.userdtos.CreateUserRequestDTO;
import com.design.dtos.userdtos.CreateUserResponseDTO;
import com.design.dtos.userdtos.ResponseStatusDTO;
import com.design.models.User;
import com.design.services.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private final UserService userService;

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
