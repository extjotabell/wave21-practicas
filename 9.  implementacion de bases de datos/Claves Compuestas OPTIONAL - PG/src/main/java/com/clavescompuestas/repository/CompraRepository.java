package com.clavescompuestas.repository;

import com.clavescompuestas.model.Compra;
import com.clavescompuestas.model.key.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CompraRepository extends JpaRepository<Compra, CompraKey> {
}
