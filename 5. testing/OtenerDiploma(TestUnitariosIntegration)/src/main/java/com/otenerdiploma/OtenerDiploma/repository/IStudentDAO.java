package com.otenerdiploma.OtenerDiploma.repository;


import com.otenerdiploma.OtenerDiploma.model.StudentDTO;

public interface IStudentDAO {
    void save(StudentDTO stu);
    boolean delete(Long id);
    boolean exists(StudentDTO stu);
    StudentDTO findById(Long id);
}