package com.otenerdiploma.OtenerDiploma.repository;


import com.otenerdiploma.OtenerDiploma.model.StudentDTO;

import java.util.Set;

public interface IStudentRepository {

    Set<StudentDTO> findAll();

}
