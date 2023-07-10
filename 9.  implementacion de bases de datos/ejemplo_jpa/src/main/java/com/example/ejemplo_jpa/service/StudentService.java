package com.example.ejemplo_jpa.service;

import com.example.ejemplo_jpa.dto.StudentDTO;
import com.example.ejemplo_jpa.model.Student;
import com.example.ejemplo_jpa.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class StudentService implements IStudentService{

private final StudentRepository stuRepo;


 //Si implemento con constructor es así:
    public StudentService (StudentRepository stuRepo) {
        this.stuRepo = stuRepo;
    }
    private final ModelMapper mapper = new ModelMapper();

    @Override
    @Transactional (readOnly = true)
    public List<StudentDTO> getStudents() {
        List<Student> studentList = stuRepo.findAll();
        return studentList.stream().map(
                student -> mapper.map(student, StudentDTO.class)
        ).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void saveStudent(Student stu) {

        stuRepo.save(stu);
    }

    @Override
    @Transactional
    public void deleteStudent(long id) {
        stuRepo.deleteById(id);
    }

    //el método edit no existe más

    @Override
    @Transactional (readOnly = true)
    public StudentDTO findStudent(long id) {
        //acá si no encuentro el student, devuelvo null, eso hace el orElse
        Student stu=stuRepo.findById(id).orElse(null);
        return mapper.map(stu, StudentDTO.class);
    }


}



