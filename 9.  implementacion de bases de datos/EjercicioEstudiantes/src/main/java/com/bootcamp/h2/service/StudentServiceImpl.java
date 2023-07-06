package com.bootcamp.h2.service;

import com.bootcamp.h2.dto.StudentDTO;
import com.bootcamp.h2.dto.response.StudentListDTO;
import com.bootcamp.h2.entity.Student;
import com.bootcamp.h2.exception.StudentNotFoundException;
import com.bootcamp.h2.repository.StudentRepository;
import com.bootcamp.h2.utils.ClassMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository stuRepo;

    public StudentServiceImpl(StudentRepository stuRepo) {
        this.stuRepo = stuRepo;
    }

    @Override
    public StudentDTO findbyId(Long id) {

        return ClassMapper.studentToStudentDTO(stuRepo.findById(id).orElseThrow(()->new StudentNotFoundException("El usuario no se encuentra registrado")));
    }

    @Override
    @Transactional
    public boolean save(StudentDTO stu) {

        stuRepo.save(ClassMapper.studentDTOToStudent(stu));
        return true;
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        Student stu = stuRepo.findById(id).orElseThrow(()->new StudentNotFoundException("El usuario no se encuentra registrado"));

        stuRepo.delete(stu);
        return true;
    }

    @Override
    @Transactional
    public StudentListDTO findall() {

        return new StudentListDTO(stuRepo.findAll().stream()
                .map(m->ClassMapper.studentToStudentDTO(m))
                .toList());
    }

    @Override
    public boolean update(StudentDTO stu) {
        Student studentToUpdate = stuRepo.findById(stu.getIdStudent()).orElseThrow(()->new StudentNotFoundException("El usuario no se encuentra registrado"));
        ;

        stuRepo.save(ClassMapper.studentDTOToStudent(stu));
        return true;
    }
}
