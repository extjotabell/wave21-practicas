package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestUtilsGenerator {
    public static StudentDTO getStudentWith3Subjects(String name) {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 6.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 4.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        StudentDTO stu = new StudentDTO();
        stu.setId(9999L);
        stu.setStudentName(name);
        stu.setSubjects(subjects);

        return stu;
    }

    public static StudentDTO getStudentWith3SubjectsAverageOf10(String name) {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 10.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 10.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        StudentDTO stu = new StudentDTO();
        stu.setId(9999L);
        stu.setStudentName(name);
        stu.setSubjects(subjects);

        return stu;
    }

    public static StudentDTO getStudentWithId(Long id) {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 6.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 4.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        StudentDTO stu = new StudentDTO();
        stu.setId(id);
        stu.setStudentName("student1");
        stu.setSubjects(subjects);

        return stu;
    }

    public static Set<StudentDTO> getStudentSet() {
        StudentDTO stu1 = getStudentWith3Subjects("Marco");
        StudentDTO stu2 = getStudentWith3Subjects("Marco Polo");
        StudentDTO stu3 = getStudentWith3Subjects("Julio");
        StudentDTO stu4 = getStudentWith3Subjects("Julio Cesar");

        return new HashSet<>() {{
            add(stu1);
            add(stu2);
            add(stu3);
            add(stu4);
        }};
    }

}