package com.hql.ej1.service;

import com.hql.ej1.model.Episode;
import com.hql.ej1.repository.IEpisodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService {

    IEpisodeRepository episodeRepository;

    public EpisodeService(IEpisodeRepository episodeRepository){
        this.episodeRepository=episodeRepository;
    }

    public List<Episode> getEpisodeByActorName(String first_name,
                                               String last_name){
        return episodeRepository.getEpisodeByActorName(first_name,last_name);
    }

}
