package com.design;

import com.design.controllers.audicontroller.AuditoriumController;
import com.design.controllers.citycontroller.CityController;
import com.design.controllers.moviecontroller.MovieController;
import com.design.controllers.showcontroller.ShowController;
import com.design.controllers.theatercontroller.TheaterController;
import com.design.controllers.usercontroller.ActorController;
import com.design.controllers.usercontroller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {

    private final UserController userController;
    private final CityController cityController;
    private final TheaterController theaterController;

    private final AuditoriumController auditoriumController;

    private final MovieController movieController;

    private final ActorController actorController;
    private final ShowController showController;

    //private static ApplicationContext ctx;

    @Autowired
   public BookMyShowApplication(UserController userController,
                                CityController cityController,
                                TheaterController theaterController,
                                AuditoriumController auditoriumController,
                                MovieController movieController,
                                ActorController actorController,
                                ShowController showController){
        this.userController = userController;
        this.cityController = cityController;
        this.theaterController = theaterController;
        this.auditoriumController = auditoriumController;
        this.movieController = movieController;
        this.actorController = actorController;
        this.showController = showController;

    }

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

   @Override
    public void run(String... args) throws Exception {
        CreateUserForApp createUserForApp = new CreateUserForApp(userController);
        createUserForApp.createUser();

        CreateCityForApp createCityForApp = new CreateCityForApp(cityController);
        createCityForApp.createCity();

        CreateTheaterForApp createTheaterForApp = new CreateTheaterForApp(theaterController);
        createTheaterForApp.addTheater();
       CreateAuditoriumForApp createAuditoriumForApp = new CreateAuditoriumForApp(auditoriumController);
       createAuditoriumForApp.addAuditorium();
       createAuditoriumForApp.addSeats();

       CreateActorForApp createActorForApp = new CreateActorForApp(actorController);
       createActorForApp.createUser();

       CreateMovieForApp createMovieForApp = new CreateMovieForApp(movieController);
       createMovieForApp.addMovie();

        CreateShowForApp createShowForApp = new CreateShowForApp(showController);
       createShowForApp.addShow();

        
    }
}
