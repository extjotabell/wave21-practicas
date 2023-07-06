package com.example.demo.service;

import com.example.demo.dto.TestCaseDTO;
import com.example.demo.dto.TestCaseIdDTO;
import com.example.demo.entity.TestCase;
import com.example.demo.exception.TestNotFoundException;
import com.example.demo.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCaseService implements ITestCaseService {

  ITestCaseRepository testCaseRepository;

  ModelMapper modelMapper;

  public TestCaseService(ITestCaseRepository testCaseRepository) {
    this.testCaseRepository = testCaseRepository;
    this.modelMapper = new ModelMapper();
  }


  @Override
  public TestCaseIdDTO createTestCase(TestCaseDTO testCase) {
    TestCase test = this.modelMapper.map(testCase, TestCase.class);

    return new TestCaseIdDTO(this.testCaseRepository.save(test).getId());
  }

  @Override
  public List<TestCaseDTO> getAllTestCase() {
    List<TestCase> tests = this.testCaseRepository.findAll();
    return tests
      .stream()
      .map(t -> modelMapper.map(t, TestCaseDTO.class))
      .toList();
  }

  @Override
  public TestCaseDTO findById(long id) {
    TestCase testCase = this.testCaseRepository.findById(id)
      .orElseThrow(TestNotFoundException::new);

    return modelMapper.map(testCase, TestCaseDTO.class);
  }

  @Override
  public void deleteTestCase(long id) {
    if(!this.testCaseRepository.existsById(id))
      throw new TestNotFoundException();

    this.testCaseRepository.deleteById(id);
  }
}
