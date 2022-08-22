package com.design.controllers.usercontroller;


import com.design.dtos.userdtos.*;
import com.design.models.Actor;
import com.design.models.User;
import com.design.services.userservice.ActorService;
import com.design.services.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ActorController {
    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService){
        this.actorService = actorService;
    }

    public CreateActorResponseDTO createActor(CreateActorRequestDTO requestDTO){
        Actor createdActor = actorService.createActor(requestDTO.getName());
        CreateActorResponseDTO responseDTO = new CreateActorResponseDTO();
        responseDTO.setActor(createdActor);
        responseDTO.setResponseStatusDTO(ResponseStatusDTO.SUCCESS);
        return responseDTO;
    }
}
