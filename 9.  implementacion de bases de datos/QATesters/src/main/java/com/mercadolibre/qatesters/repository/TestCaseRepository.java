package com.mercadolibre.qatesters.repository;

import com.mercadolibre.qatesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<TestCase,Long> {
}
