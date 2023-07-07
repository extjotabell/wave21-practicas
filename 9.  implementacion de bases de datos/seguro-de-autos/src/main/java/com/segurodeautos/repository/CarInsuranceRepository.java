package com.segurodeautos.repository;

import com.segurodeautos.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarInsuranceRepository extends JpaRepository<Car,Long> {
}
