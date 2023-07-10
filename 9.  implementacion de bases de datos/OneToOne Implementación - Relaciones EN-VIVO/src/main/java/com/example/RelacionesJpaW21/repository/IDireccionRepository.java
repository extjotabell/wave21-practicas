package com.example.RelacionesJpaW21.repository;

import com.example.RelacionesJpaW21.entity.OneToOne.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDireccionRepository extends JpaRepository<Address,Long> {
}
