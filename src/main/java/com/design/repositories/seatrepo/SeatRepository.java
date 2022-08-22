package com.design.repositories.seatrepo;

import com.design.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    @Override
    <S extends Seat> List<S> saveAll(Iterable<S> entities);
}
