package com.bootcamp.test.service;

import com.bootcamp.test.dto.TestCaseDTO;

import java.util.List;

public interface TestCaseService {
    TestCaseDTO saveTestCase(TestCaseDTO tc);
    Boolean deleteTestCase(Long id);
    List<TestCaseDTO> findAll();
    TestCaseDTO findById(Long id);

    TestCaseDTO update (Long id, TestCaseDTO dto);

}
