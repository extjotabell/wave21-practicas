package com.bootcamp.LasPerlas.repository;

import com.bootcamp.LasPerlas.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJewelryRepository extends JpaRepository<Jewel,Long> {
}
