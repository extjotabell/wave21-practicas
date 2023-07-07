package com.example.demo.service;

import com.example.demo.dto.MiniSerieDTO;
import com.example.demo.dto.MiniSerieIdDTO;

public interface IMiniSerieService {
  MiniSerieIdDTO createMiniSerie(MiniSerieDTO miniSerieDto);
}
