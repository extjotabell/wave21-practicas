package com.example.demo.service;

import com.example.demo.model.TestCase;
import com.example.demo.repository.TestCaseRepository;

import java.util.List;

public class TestCaseService implements ITestCaseService{

    private final TestCaseRepository testRepo;

    public TestCaseService(TestCaseRepository testRepo){
        this.testRepo = testRepo;
    }
    @Override
    public Long saveTest(TestCase test) {
        return testRepo.save(test).getId_case();
    }

    @Override
    public List<TestCase> getTests() {
        return testRepo.findAll();
    }

    @Override
    public TestCase getTestById(Long id) {
        return testRepo.findById(id).orElse(null);
    }

    @Override
    public String updateTest(TestCase test, Long id) {
        TestCase testOriginal = testRepo.findById(id).orElse(null);
        testOriginal.setDescription(test.getDescription());
        testOriginal.setLast_update(test.getLast_update());
        testOriginal.setPassed(test.getPassed());
        testOriginal.setNumber_of_tries(test.getNumber_of_tries());
        this.saveTest(testOriginal);
        return "Test actualizado";
    }

    @Override
    public String deleteTest(Long id) {
        testRepo.deleteById(id);
        return "Eliminado correctamente";
    }
}
