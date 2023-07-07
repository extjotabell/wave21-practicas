package com.hql.ej1.repository;

import com.hql.ej1.model.Actor;
import com.hql.ej1.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {
    @Query("SELECT a FROM Actor a WHERE a.favoriteMovie is not null")
    List<Actor> getAllByNotNullFavoriteMovie();

    @Query(value = "SELECT a FROM Actor a WHERE a.rating>:rating")
    List<Actor> getAllFilteredByHighestRating(@Param(value = "rating")Integer rating);

    @Query("SELECT a FROM Actor a WHERE :movie in elements(a.actorMovie)")
    List<Actor> getAllByMovie(@Param(value = "movie") Movie movie);
}
