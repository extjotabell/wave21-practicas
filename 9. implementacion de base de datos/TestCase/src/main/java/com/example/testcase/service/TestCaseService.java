package com.example.testcase.service;

import com.example.testcase.dto.TestCaseDTO;
import com.example.testcase.model.TestCase;
import com.example.testcase.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService {
    private final ITestCaseRepository testCaseRepository;
    private final ModelMapper modelMapper;
    public TestCaseService(ITestCaseRepository testCaseRepository, ModelMapper modelMapper){
        this.testCaseRepository = testCaseRepository;
        this.modelMapper = modelMapper;
    }
    public TestCaseDTO create(TestCaseDTO testCaseDTO){
        testCaseDTO.setId_case(null);

        TestCase testCase = modelMapper.map(testCaseDTO, TestCase.class);
        testCase.setLast_updated(LocalDate.now());
        return modelMapper.map(testCaseRepository.save(testCase), TestCaseDTO.class);
    }

    public List<TestCaseDTO> findAll(LocalDate last_updated) {
        List<TestCase> testCases =  testCaseRepository.findAll();
        List<TestCaseDTO> testCaseDTOS = testCases.stream()
                .map(testCase -> modelMapper.map(testCase, TestCaseDTO.class))
                .toList();

        if(last_updated!=null)
            return testCaseDTOS.stream()
                    .filter(testCaseDTO -> testCaseDTO.getLast_updated().isAfter(last_updated))
                    .toList();

       return testCaseDTOS;
    }

    public TestCaseDTO findById(Long id) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow();

        return modelMapper.map(testCase, TestCaseDTO.class);
    }

    public TestCaseDTO updateById(Long id, TestCaseDTO testCaseDTO) {
        if(!testCaseRepository.existsById(id)) throw new RuntimeException("El test no existe");

        TestCase testCase = modelMapper.map(testCaseDTO, TestCase.class);
        testCase.setId_case(id);
        testCase.setLast_updated(LocalDate.now());

        testCaseRepository.save(testCase);

        return modelMapper.map(testCase, TestCaseDTO.class);
    }

    public void deleteById(Long id) {
        testCaseRepository.deleteById(id);
    }
}
