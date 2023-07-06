package com.example.demoDB.service;

import com.example.demoDB.model.Student;
import com.example.demoDB.repository.IStudentRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    private final IStudentRepository stuRepo;

    public StudentService(IStudentRepository stuRepo) {
        this.stuRepo = stuRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudent() {
        List<Student> studentList = stuRepo.findAll();
        return studentList;
    }

    @Override
    public void saveStudent(Student stu) {
        stuRepo.save(stu);
    }

    @Override
    public void deleteStudent(long id) {
        stuRepo.deleteById(id);
    }

    @Override
    public Student findStudent(long id) {
        Student stu = stuRepo.findById(id).orElse(null);
        return stu;
    }
}
