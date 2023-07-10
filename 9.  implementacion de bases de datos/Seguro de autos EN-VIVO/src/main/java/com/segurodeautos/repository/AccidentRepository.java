package com.segurodeautos.repository;

import com.segurodeautos.model.Accident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentRepository extends JpaRepository<Accident, Long> {

}
