package com.ejerciciopracticoindividual.joyeria.repository;

import com.ejerciciopracticoindividual.joyeria.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya,Integer> {
}
