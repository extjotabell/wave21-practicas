package com.example.ejemplo_jpa.service;

import com.example.ejemplo_jpa.dto.StudentDTO;
import com.example.ejemplo_jpa.model.Student;
import java.util.List;

public interface IStudentService {

    public List<StudentDTO> getStudents ();
    public void saveStudent (Student stu);
    public void deleteStudent (long id);
    public StudentDTO findStudent (long id);



}
