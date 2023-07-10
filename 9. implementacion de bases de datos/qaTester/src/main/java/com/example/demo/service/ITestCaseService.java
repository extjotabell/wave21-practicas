package com.example.demo.service;

import com.example.demo.dto.TestCaseDTO;
import com.example.demo.dto.TestCaseIdDTO;

import java.util.List;

public interface ITestCaseService {

  TestCaseIdDTO createTestCase(TestCaseDTO testCase);
  List<TestCaseDTO> getAllTestCase();
  TestCaseDTO findById(long id);
  void deleteTestCase(long id);
}
