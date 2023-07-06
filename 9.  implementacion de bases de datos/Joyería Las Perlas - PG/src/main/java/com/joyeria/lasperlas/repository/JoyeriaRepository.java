package com.joyeria.lasperlas.repository;

import com.joyeria.lasperlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyeriaRepository extends JpaRepository<Joya, Long> {
}
