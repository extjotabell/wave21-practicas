package com.bootcamp.h2.service;

import com.bootcamp.h2.dto.StudentDTO;
import com.bootcamp.h2.dto.response.StudentListDTO;

import java.util.List;

public interface StudentService {
    StudentDTO findbyId(Long id);
    boolean save(StudentDTO stu);
    boolean delete(Long id);
    StudentListDTO findall();
    boolean update(StudentDTO stu);
}
