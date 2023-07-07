package com.bootcamp.test.repository;

import com.bootcamp.test.entitie.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase,Long> {
}
