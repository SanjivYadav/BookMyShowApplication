package com.design.services.theaterservice;

import com.design.Exception.CityNotFoundException;
import com.design.models.City;
import com.design.models.Theater;
import com.design.repositories.cityrepo.CityRepository;
import com.design.repositories.theaterrepo.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TheaterService {
    private TheaterRepository theaterRepository;
    private CityRepository cityRepository;

    @Autowired
    public TheaterService(TheaterRepository theaterRepository, CityRepository cityRepository){
        this.theaterRepository = theaterRepository;
        this.cityRepository = cityRepository;
    }

    public Theater addTheater(String name, String address, Long cityId) throws CityNotFoundException {
        Theater newTheater = new Theater();
        newTheater.setName(name);
        newTheater.setAddress(address);
        Optional<City> city = cityRepository.findById(cityId);
        if(!city.isPresent()){
            throw new CityNotFoundException("City Not Found");
        }

        Theater savedTheater = theaterRepository.save(newTheater);
        city.get().addTheater(savedTheater);
        cityRepository.save(city.get());
        return savedTheater;
    }
}
