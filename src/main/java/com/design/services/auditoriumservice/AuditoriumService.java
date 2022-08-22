package com.design.services.auditoriumservice;

import com.design.Exception.AuditoriumNotFoundException;
import com.design.Exception.TheaterNotFoundException;
import com.design.models.*;
import com.design.repositories.auditoriumrepo.AuditoriumRepository;
import com.design.repositories.seatrepo.SeatRepository;
import com.design.repositories.theaterrepo.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AuditoriumService {
    private final AuditoriumRepository auditoriumRepository;
    private final TheaterRepository theaterRepository;

    private final SeatRepository seatRepository;

    @Autowired
    public AuditoriumService(AuditoriumRepository auditoriumRepository,
                             TheaterRepository theaterRepository,
                             SeatRepository seatRepository){
        this.auditoriumRepository = auditoriumRepository;
        this.theaterRepository = theaterRepository;
        this.seatRepository = seatRepository;
    }

    public Auditorium addAuditorium(int auditorium_no, int capacity, List<AuditoriumFeature> auditoriumFeatures, Long theaterId) throws TheaterNotFoundException {
        Auditorium newAuditorium = new Auditorium();
        newAuditorium.setAnudi_no(auditorium_no);
        newAuditorium.setAuditoriumFeatures(auditoriumFeatures);
        newAuditorium.setCapacity(capacity);

        Optional<Theater> savedTheater = theaterRepository.findById(theaterId);
        if(!savedTheater.isPresent()){
            throw new TheaterNotFoundException("Theater does not exist");
        }
        newAuditorium.setTheater(savedTheater.get());
        Auditorium savedAudi = auditoriumRepository.save(newAuditorium);
        savedTheater.get().addAuditorium(savedAudi);
        theaterRepository.save(savedTheater.get());
        return savedAudi;
    }

    public List<Seat> addSeats(Long audi_id, Map<SeatType,Integer> seatTypes) throws AuditoriumNotFoundException {
        Optional<Auditorium> auditorium = auditoriumRepository.findById(audi_id);
        if(!auditorium.isPresent()){
            throw new AuditoriumNotFoundException("Auditorium not found");
        }
        List<Seat> seats = new ArrayList<>();
        for(Map.Entry<SeatType, Integer> entry : seatTypes.entrySet()){
            for(int i=0;i<entry.getValue();++i){
                Seat seat = new Seat();
                seat.setType(entry.getKey());
                seat.setSeat_no(entry.getKey().toString()+ (i + 1));
                seats.add(seat);
            }
        }
        List<Seat> savedSeats = seatRepository.saveAll(seats);
        auditorium.get().setSeats(savedSeats);
        auditoriumRepository.save(auditorium.get());
        return savedSeats;
    }
}
