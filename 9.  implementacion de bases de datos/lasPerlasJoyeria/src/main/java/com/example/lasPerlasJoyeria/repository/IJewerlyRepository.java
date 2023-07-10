package com.example.lasPerlasJoyeria.repository;

import com.example.lasPerlasJoyeria.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewerlyRepository extends JpaRepository<Jewel, Integer> {
}
