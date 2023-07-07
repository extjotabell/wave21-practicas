package com.bootcamp.movies.utils;

import com.bootcamp.movies.dto.StudentDTO;

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
