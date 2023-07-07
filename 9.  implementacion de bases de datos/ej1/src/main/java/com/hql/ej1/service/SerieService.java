package com.hql.ej1.service;

import com.hql.ej1.model.Serie;
import com.hql.ej1.repository.ISerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    ISerieRepository serieRepository;

    public SerieService(ISerieRepository serieRepository){
        this.serieRepository=serieRepository;
    }

    public List<Serie> getAllByNumberOfSeasons(Integer number){
        return serieRepository.getAllByNumberOfSeasons(number);
    }
}
