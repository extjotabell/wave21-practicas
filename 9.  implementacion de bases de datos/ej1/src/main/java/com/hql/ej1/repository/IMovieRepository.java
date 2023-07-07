package com.hql.ej1.repository;

import com.hql.ej1.model.Genre;
import com.hql.ej1.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie,Integer> {
    @Query(value = "SELECT DISTINCT m FROM Movie m JOIN m.actors a WHERE a.rating >:rating")
    List<Movie> getAllByActorRating(@Param("rating")Integer rating);
    @Query("SELECT m FROM Movie m WHERE m.genre_id =:genre")
    List<Movie> getAllByGenre(@Param(value = "genre") Genre genre);
}
