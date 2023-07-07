package com.hql.ej1.repository;

import com.hql.ej1.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Serie,Integer> {

    @Query("SELECT DISTINCT s FROM Serie s JOIN s.seasons sea WHERE (SELECT COUNT(seasons.id) FROM Serie ser JOIN ser.seasons seasons WHERE seasons.serie.id = s.id GROUP BY ser.id) > :number")
    List<Serie> getAllByNumberOfSeasons(@Param("number") Integer number);
}
