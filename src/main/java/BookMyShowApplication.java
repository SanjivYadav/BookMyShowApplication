package com.design.bookmyshowapplication;

import com.design.controllers.UserController;
import com.design.dtos.CreateUserRequestDTO;
import com.design.dtos.CreateUserResponseDTO;
import com.design.dtos.ResponseStatusDTO;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.design")
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.design"})
public class BookMyShowApplication implements ApplicationContextAware, CommandLineRunner {

    //private final UserController userController;

    private static ApplicationContext ctx;

    //@Autowired
   /* public BookMyShowApplication(UserController userController){
        this.userController = userController;
    }*/

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }

   @Override
    public void run(String... args) throws Exception {
       UserController userController = ctx.getBean(UserController.class);
       System.out.println("controller"+userController);
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
