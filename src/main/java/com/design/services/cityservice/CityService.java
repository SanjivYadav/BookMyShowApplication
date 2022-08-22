package com.design.services.cityservice;

import com.design.models.City;
import com.design.repositories.cityrepo.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }
    public City createCity(String name){
        City newCity = new City();
        newCity.setName(name);

        return cityRepository.save(newCity);

    }
}
