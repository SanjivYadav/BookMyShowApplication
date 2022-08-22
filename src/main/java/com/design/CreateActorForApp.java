package com.design;

import com.design.controllers.usercontroller.ActorController;
import com.design.controllers.usercontroller.UserController;
import com.design.dtos.userdtos.*;

public class CreateActorForApp {

    private final ActorController actorController;
    public CreateActorForApp(ActorController actorController){
        this.actorController = actorController;
    }

    public void createUser(){
        CreateActorRequestDTO requestDTO = new CreateActorRequestDTO();
        requestDTO.setName("Amir Khan");
        CreateActorResponseDTO responseDTO = actorController.createActor(requestDTO);
        if(responseDTO.getResponseStatusDTO().equals(ResponseStatusDTO.FAILURE)){
            System.out.println("Something went wrong");
        }
        else{
            System.out.println("Actor Created with name : "+responseDTO.getActor().getName());
        }
    }

}
