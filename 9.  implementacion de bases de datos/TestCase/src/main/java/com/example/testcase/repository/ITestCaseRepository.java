package com.example.testcase.repository;

import com.example.testcase.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
}
