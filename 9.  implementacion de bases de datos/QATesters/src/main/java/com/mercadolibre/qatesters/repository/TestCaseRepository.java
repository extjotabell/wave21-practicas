package com.mercadolibre.qatesters.repository;

import com.mercadolibre.qatesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TestCaseRepository extends CrudRepository<TestCase,Long> {
}
