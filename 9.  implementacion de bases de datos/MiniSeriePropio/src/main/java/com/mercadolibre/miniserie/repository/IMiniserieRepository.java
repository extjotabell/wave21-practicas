package com.mercadolibre.miniserie.repository;

import com.mercadolibre.miniserie.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniserieRepository extends JpaRepository <MiniSerie, Long> {
    
}
