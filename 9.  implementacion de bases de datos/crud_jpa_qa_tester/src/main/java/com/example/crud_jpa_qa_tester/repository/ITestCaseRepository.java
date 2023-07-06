package com.example.crud_jpa_qa_tester.repository;

import com.example.crud_jpa_qa_tester.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
}
