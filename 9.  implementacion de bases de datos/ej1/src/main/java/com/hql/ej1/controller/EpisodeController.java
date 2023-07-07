package com.hql.ej1.controller;

import com.hql.ej1.model.Episode;
import com.hql.ej1.service.EpisodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ep")
public class EpisodeController {

    EpisodeService episodeService;

    public EpisodeController(EpisodeService episodeService){
        this.episodeService=episodeService;
    }

    @GetMapping("/{first_name}/{last_name}")
    public List<Episode> getEpisodeByActorName(@PathVariable String first_name,
                                               @PathVariable String last_name){
        return episodeService.getEpisodeByActorName(first_name,last_name);
    }
}
