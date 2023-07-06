package com.bootcamp.h2.utils;

import com.bootcamp.h2.dto.StudentDTO;
import com.bootcamp.h2.entity.Student;

public class ClassMapper {

    public static Student studentDTOToStudent(StudentDTO dto){

        Student stu = new Student();
        stu.setIdStudent(dto.getIdStudent());
        stu.setDni(dto.getDni());
        stu.setFirstName(dto.getFirstName());
        stu.setLastName(dto.getLastName());

        return stu;
    }

    public static  StudentDTO studentToStudentDTO(Student stu){

        return new StudentDTO(stu.getIdStudent(),stu.getFirstName(),stu.getLastName(),stu.getDni());
    }
}
