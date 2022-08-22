package com.design.services.movieservice;

import com.design.models.Actor;
import com.design.models.Language;
import com.design.models.Movie;
import com.design.models.MovieFeature;
import com.design.repositories.movierepo.MovieRepository;
import com.design.repositories.userrepo.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    private ActorRepository actorRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository, ActorRepository actorRepository){
        this.movieRepository =movieRepository;
        this.actorRepository = actorRepository;
    }

    public Movie addMovie(String name, List<Long> actors_id, List<Language> languages,
                          List<MovieFeature> movieFeatures, int duration, double rating) throws Exception {

        Movie newMovie = new Movie();
        newMovie.setName(name);
        newMovie.setLanguages(languages);
        newMovie.setMovieFeatures(movieFeatures);
        newMovie.setDuration(duration);
        newMovie.setRating(rating);

        List<Actor> actors = actorRepository.findAllById(actors_id);
        if(actors == null || actors.size() ==0 || actors.size() != actors_id.size()){
            throw new Exception("All actors not found");
        }
        newMovie.setActors(actors);
        Movie createdMovie = movieRepository.save(newMovie);

        for(Actor actor : actors){
            actor.addMovie(createdMovie);
        }
        actorRepository.saveAll(actors);
        return createdMovie;

    }
}
