package com.example.joyeria.repository;

import com.example.joyeria.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJewelRepository extends JpaRepository<Jewel, Long> {
}
