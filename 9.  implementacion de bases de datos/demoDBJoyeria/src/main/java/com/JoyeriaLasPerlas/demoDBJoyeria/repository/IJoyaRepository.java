package com.JoyeriaLasPerlas.demoDBJoyeria.repository;

import com.JoyeriaLasPerlas.demoDBJoyeria.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya,Integer> {

}
