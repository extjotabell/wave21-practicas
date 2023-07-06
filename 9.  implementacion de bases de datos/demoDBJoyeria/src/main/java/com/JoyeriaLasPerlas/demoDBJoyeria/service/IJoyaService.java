package com.example.demoDB.service;

import com.example.demoDB.model.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> getStudent();

    public void saveStudent (Student stu);
    public void deleteStudent (long id);
    public Student findStudent (long id);

}
