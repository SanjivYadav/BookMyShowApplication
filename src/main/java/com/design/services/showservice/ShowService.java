package com.design.services.showservice;

import com.design.Exception.AuditoriumNotFoundException;
import com.design.Exception.MovieNotFoundException;
import com.design.models.*;
import com.design.repositories.auditoriumrepo.AuditoriumRepository;
import com.design.repositories.movierepo.MovieRepository;
import com.design.repositories.showrepo.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShowService {
    private final ShowRepository showRepository;
    private final AuditoriumRepository auditoriumRepository;

    private final MovieRepository movieRepository;

    @Autowired
    public ShowService(ShowRepository showRepository,
                       MovieRepository movieRepository,
                       AuditoriumRepository auditoriumRepository){
        this.showRepository = showRepository;
        this.movieRepository= movieRepository;
        this.auditoriumRepository= auditoriumRepository;
    }

    public Show addShow(Long movie_id,
                        Long audi_no,
                        Date start_time,
                        Date end_time,
                        List<ShowFeature> showFeatures,
                        Map<SeatType, Double> showSeatTypePrice) throws AuditoriumNotFoundException, MovieNotFoundException {
        Show newShow = new Show();
        newShow.setStart_time(start_time);
        newShow.setEnd_time(end_time);
        newShow.setShowFeatures(showFeatures);
        newShow.setLanguage(Language.HINDI);

        Optional<Auditorium> auditorium = auditoriumRepository.findById(audi_no);
        Optional<Movie> movie = movieRepository.findById(movie_id);
        if(!auditorium.isPresent()){
            throw new AuditoriumNotFoundException("Auditorium not found");
        }
        if(!movie.isPresent()){
            throw new MovieNotFoundException("Movie not found");
        }
        newShow.setAuditorium(auditorium.get());
        Show savedShow = showRepository.save(newShow);
        List<ShowSeat> showSeats = new ArrayList<>();
        List<ShowSeatType> showSeatTypes = new ArrayList<>();
        List<Seat> seats = auditorium.get().getSeats();
        for(Seat seat : seats){
            ShowSeat showSeat = new ShowSeat();
            showSeat.setShow(savedShow);
            showSeat.setSeat(seat);
            showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
            showSeats.add(showSeat);

            ShowSeatType showSeatTye = new ShowSeatType();
            showSeatTye.setShow(savedShow);
            showSeatTye.setSeatType(seat.getType());
            showSeatTye.setPrice(showSeatTypePrice.get(seat.getType()));
            showSeatTypes.add(showSeatTye);
        }
        savedShow.setShowSeats(showSeats);
        savedShow.setShowSeatTypes(showSeatTypes);


        savedShow.setMovie(movie.get());
        savedShow = showRepository.save(savedShow);
        return savedShow;
    }



}
