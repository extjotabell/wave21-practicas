package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.dto.response.ResponseDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class StudentService implements IStudentService {

    @Autowired
    IStudentDAO studentDAO;

    @Autowired
    IStudentRepository studentRepository;

    @Override
    public ResponseDTO create(StudentDTO stu) {
        studentDAO.save(stu);
        return new ResponseDTO("Creacion realizada con exito!");
    }

    @Override
    public StudentDTO read(Long id) {
        return studentDAO.findById(id);
    }

    @Override
    public Optional<StudentDTO> update(StudentDTO stu) {
        return studentDAO.update(stu);
    }

    @Override
    public ResponseDTO delete(Long id) {
        studentDAO.delete(id);
        return new ResponseDTO("Eliminacion exitosa...");
    }

    @Override
    public Set<StudentDTO> getAll() {
        return this.studentRepository.findAll();
    }
}
