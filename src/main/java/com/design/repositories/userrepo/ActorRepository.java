package com.design.repositories.userrepo;

import com.design.models.Actor;
import com.design.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    @Override
    Actor save(Actor actor);

    @Override
    <S extends Actor> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Actor> findById(Long id);

    @Override
    List<Actor> findAllById(Iterable<Long> longs);
}
