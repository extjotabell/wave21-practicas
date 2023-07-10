package com.example.demo.service;

import com.example.demo.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    Long saveTest(TestCase test);

    List<TestCase> getTests();

    TestCase getTestById(Long id);

    String updateTest(TestCase test, Long id);

    String deleteTest(Long id);

    String getTestCaseUpdate(LocalDate fecha);
}
