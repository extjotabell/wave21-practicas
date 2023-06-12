package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.dto.response.ResponseDTO;
import com.meli.obtenerdiploma.model.StudentDTO;

import java.util.Optional;
import java.util.Set;

public interface IStudentService {
    ResponseDTO create(StudentDTO stu);
    StudentDTO read(Long id);
    Optional<StudentDTO> update(StudentDTO stu);
    ResponseDTO delete(Long id);
    Set<StudentDTO> getAll();
}
