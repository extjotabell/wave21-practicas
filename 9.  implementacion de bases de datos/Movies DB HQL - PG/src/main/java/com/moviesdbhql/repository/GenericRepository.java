package com.moviesdbhql.repository;

import com.moviesdbhql.model.entities.Actors;
import com.moviesdbhql.model.entities.Episodes;
import com.moviesdbhql.model.entities.Movies;
import com.moviesdbhql.model.entities.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenericRepository extends JpaRepository<Actors,Long> {
    @Query("FROM Actors a WHERE a.favoriteMovieId <> null")
    List<Actors> getActorsWithFavoriteMovie();

    @Query("FROM Actors a WHERE a.rating >=:rating")
    List<Actors> getActorsRatingGreaterThanParam(@Param("rating") Double rating);

    @Query("SELECT a FROM Actors a INNER JOIN a.movies AS m")
    List<Actors> getActorsWorkInParam(Long movieId);

    @Query("SELECT m FROM Actors a INNER JOIN a.movies AS m WHERE a.rating >=:rating")
    List<Movies> getMoviesWithActorsWithRatingGreaterThanParam(Double rating);

    @Query("SELECT m FROM Genres g INNER JOIN g.movies AS m WHERE g.id =:genreId")
    List<Movies> getMoviesInGenreParam(Long genreId);

    @Query("SELECT s FROM Genres g INNER JOIN g.series AS s WHERE count(s) >=:seasonsQuantity ")
    List<Series> getSeriesWithSeasonsNumberGreaterThanParam(int seasonsQuantity);

    @Query("SELECT e FROM Actors a INNER JOIN a.episodes AS e WHERE a.id =:actorId")
    List<Episodes> getEpisodesFromAnySeriesWhenActorParamWorks(Long actorId);
}