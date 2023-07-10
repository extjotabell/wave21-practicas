package com.example.demo.service;

import com.example.demo.dto.MiniSerieDTO;
import com.example.demo.dto.MiniSerieIdDTO;
import com.example.demo.entity.MiniSerie;
import com.example.demo.repository.IMiniserieRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieService implements IMiniSerieService {

  @Autowired
  IMiniserieRepository miniserieRepository;

  @Override
  public MiniSerieIdDTO createMiniSerie(final MiniSerieDTO miniSerieDto) {
    MiniSerie miniSerie = new MiniSerie();

    miniSerie.setName(miniSerieDto.name());
    miniSerie.setAmountOfAwards(miniSerieDto.awards());
    miniSerie.setRating(miniSerieDto.rating());

    MiniSerie m = miniserieRepository.save(miniSerie);
    return new MiniSerieIdDTO(m.getId());
  }
}
