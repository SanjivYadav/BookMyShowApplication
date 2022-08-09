package com.design;

import com.design.controllers.UserController;
import com.design.dtos.CreateUserRequestDTO;
import com.design.dtos.CreateUserResponseDTO;
import com.design.dtos.ResponseStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {

    private UserController userController;

    //private static ApplicationContext ctx;

    @Autowired
   public BookMyShowApplication(UserController userController){
        this.userController = userController;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

   @Override
    public void run(String... args) throws Exception {
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
