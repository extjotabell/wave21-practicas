package com.example.crud_jpa_qa_tester.service;

import com.example.crud_jpa_qa_tester.entity.TestCase;
import com.example.crud_jpa_qa_tester.repository.ITestCaseRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class TestCaseService implements ITestCaseService {

    ITestCaseRepository repository;

    public TestCaseService(ITestCaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public TestCase saveTestCase(TestCase testCase) {
        return repository.save(testCase);
    }

    @Override
    public List<TestCase> findAllTestCase() {
        return repository.findAll();
    }

    @Override
    public Optional<TestCase> findOneTestCase(Long id) {
        return repository.findById(id);
    }

    @Override
    public String updateTestCase(Long id, TestCase testCase) {
        Optional<TestCase> founded = repository.findById(id);
        if (founded.isPresent()) {
            saveTestCase(testCase);
            return "Fue actualizado";
        }
        return "No fue actualizado";
    }


    @Override
    public String deleteTestCase(Long id) {
        repository.deleteById(id);
        return "Borrado";

    }
}
