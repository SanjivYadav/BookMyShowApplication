package com.design.services.userservice;
import com.design.models.Actor;
import com.design.models.User;
import com.design.repositories.userrepo.ActorRepository;
import com.design.repositories.userrepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {

    private final ActorRepository repository;

    @Autowired
    public ActorService(ActorRepository repository){
        this.repository = repository;
    }

    public Actor createActor(String name){
        Actor newActor = new Actor();
        newActor.setName(name);

       return repository.save(newActor);
    }
}
