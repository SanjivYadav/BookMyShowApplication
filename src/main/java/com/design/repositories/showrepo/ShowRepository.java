package com.design.repositories.showrepo;

import com.design.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    @Override
    Show save(Show show);
}
