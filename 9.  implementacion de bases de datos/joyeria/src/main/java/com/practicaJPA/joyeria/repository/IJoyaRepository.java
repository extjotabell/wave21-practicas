package com.practicaJPA.joyeria.repository;

import com.practicaJPA.joyeria.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyaRepository extends JpaRepository <Joya, Integer> {
}
