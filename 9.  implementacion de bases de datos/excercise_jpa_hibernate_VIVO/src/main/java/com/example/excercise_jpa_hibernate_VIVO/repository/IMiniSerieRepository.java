package com.example.excercise_jpa_hibernate_VIVO.repository;

import com.example.excercise_jpa_hibernate_VIVO.entity.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
