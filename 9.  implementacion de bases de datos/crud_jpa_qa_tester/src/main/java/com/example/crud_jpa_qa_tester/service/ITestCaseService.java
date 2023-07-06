package com.example.crud_jpa_qa_tester.service;

import com.example.crud_jpa_qa_tester.entity.TestCase;

import java.util.List;
import java.util.Optional;

public interface ITestCaseService {

    TestCase saveTestCase(TestCase testCase);
    List<TestCase> findAllTestCase();
    Optional<TestCase> findOneTestCase(Long id);
    String updateTestCase(Long id, TestCase testCase);
    String deleteTestCase(Long id);

}
