package com.example.Miniseries.repository;

import com.example.Miniseries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniserieRepository extends JpaRepository <MiniSerie,Long> {
    
}
