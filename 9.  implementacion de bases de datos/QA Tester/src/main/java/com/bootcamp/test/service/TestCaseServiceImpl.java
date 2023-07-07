package com.bootcamp.test.service;

import com.bootcamp.test.dto.TestCaseDTO;
import com.bootcamp.test.entitie.TestCase;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.bootcamp.test.repository.TestCaseRepository;

import java.util.List;

@Service
public class TestCaseServiceImpl implements TestCaseService {

    private TestCaseRepository tcRepo;
    private ModelMapper mapper;

    public TestCaseServiceImpl(TestCaseRepository tcRepo) {
        this.tcRepo = tcRepo;
        this.mapper = new ModelMapper();
    }

    @Override
    public TestCaseDTO saveTestCase(TestCaseDTO tc) {
        TestCase testCase = mapper.map(tc, TestCase.class);


        return mapper.map(tcRepo.save(testCase),TestCaseDTO.class);
    }

    @Override
    public Boolean deleteTestCase(Long id) {
        tcRepo.delete(tcRepo.findById(id).orElseThrow(()->new RuntimeException("Test Not Found")));
        return true;
    }

    @Override
    public List<TestCaseDTO> findAll() {
        return tcRepo.findAll().stream().map(m->mapper.map(m,TestCaseDTO.class)).toList();

    }

    @Override
    public TestCaseDTO findById(Long id) {

        return mapper.map(tcRepo.findById(id).orElseThrow(()->new RuntimeException("Test Not Found")),TestCaseDTO.class);
    }

    @Override
    public TestCaseDTO update(Long id, TestCaseDTO dto) {

        TestCase caseUpdated = mapper.map(dto, TestCase.class);
        TestCase caseToUpdate = tcRepo.findById(id).orElseThrow(()->new RuntimeException("TEst not found"));
        caseUpdated.setId_case(id);
        tcRepo.save(caseToUpdate);
        return mapper.map(caseUpdated,TestCaseDTO.class);
    }
}
