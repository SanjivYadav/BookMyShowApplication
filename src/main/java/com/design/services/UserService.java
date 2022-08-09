package com.design.service;

import com.design.model.User;
import com.design.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public User createUser(String name, String emailId){
        User newUSer = new User();
        newUSer.setEmail(emailId);
        newUSer.setName(name);

       return repository.save(newUSer);
    }
}
