package com.example.MiniSeries.repository;

import com.example.MiniSeries.model.Miniserie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniserieRepository extends JpaRepository<Miniserie, Long> {
}