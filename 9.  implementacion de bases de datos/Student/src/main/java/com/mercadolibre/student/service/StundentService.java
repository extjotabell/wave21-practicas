package com.mercadolibre.student.service;

import com.mercadolibre.student.model.Student;
import com.mercadolibre.student.repository.StudentRepositoy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Service
public class StundentService implements IStudentService{

    private final StudentRepositoy stuRepo;

    public StundentService(StudentRepositoy stuRepo) {
        this.stuRepo = stuRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        List<Student> studentList = stuRepo.findAll();
        return studentList;
    }

    @Override
    @Transactional(readOnly = true)
    public Student findStudent(long id){
        Student stu = stuRepo.findById(id).orElse(null);
        return stu;
    }

    @Override
    @Transactional
    public void saveStudent(Student stu){
        stuRepo.save(stu);
    }

    @Override
    @Transactional
    public void deleteStudent(long id){
        stuRepo.deleteById(id);
    }





}
