package com.bootcamp.movies.repository;

import com.bootcamp.movies.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Long> {

    List<Actor> findActorByFirstNameContains(String name);
    List<Actor> findActorByRatingIsAfterOrderByRating(Double rating);
    @Query("FROM Actor as A WHERE A.rating > 7")
    List<Actor> findActorByGoodRating();
}
