package com.design.repositories.auditoriumrepo;

import com.design.models.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
    @Override
    Auditorium save(Auditorium auditorium);
}
