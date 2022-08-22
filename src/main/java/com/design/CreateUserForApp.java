package com.design;

import com.design.controllers.usercontroller.UserController;
import com.design.dtos.userdtos.CreateUserRequestDTO;
import com.design.dtos.userdtos.CreateUserResponseDTO;
import com.design.dtos.userdtos.ResponseStatusDTO;

public class CreateUserForApp {

    private final UserController userController;
    public CreateUserForApp(UserController userController){
        this.userController = userController;
    }

    public void createUser(){
        CreateUserRequestDTO requestDTO = new CreateUserRequestDTO();
        requestDTO.setName("Sanjiv");
        requestDTO.setEmailId("abc@gamil.com");
        CreateUserResponseDTO responseDTO = userController.createUser(requestDTO);
        if(responseDTO.getResponseStatusDTO().equals(ResponseStatusDTO.FAILURE)){
            System.out.println("Something went wrong");
        }
        else{
            System.out.println("User Created with name : "+responseDTO.getUser().getName());
        }
    }

}
