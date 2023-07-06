package com.example.crudJpa.service;

import com.example.crudJpa.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getStudents();
    void saveStudent(Student student);
    void deleteStudent(Long id);
    Student findStudent(Long id);
}
