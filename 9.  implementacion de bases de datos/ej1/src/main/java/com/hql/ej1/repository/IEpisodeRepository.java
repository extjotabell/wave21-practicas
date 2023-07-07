package com.hql.ej1.repository;

import com.hql.ej1.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode,Integer> {

    @Query("SELECT e From Episode e JOIN e.episodeActor a WHERE a.first_name =:first_name AND a.last_name =:last_name")
    List<Episode> getEpisodeByActorName(@Param("first_name") String first_name,
                                        @Param("last_name") String last_name);
}
