package com.Tester.demoDBTester.repository;

import com.Tester.demoDBTester.model.Testcase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITestCaseRepository extends JpaRepository<Testcase, Long> {
}
