package com.bootcamp.autos.repository;

import com.bootcamp.autos.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {
}
