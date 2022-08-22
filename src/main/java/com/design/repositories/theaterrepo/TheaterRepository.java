package com.design.repositories.theaterrepo;

import com.design.models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {
    @Override
    Theater save(Theater theater);

    @Override
    Optional<Theater> findById(Long theaterId);
}
