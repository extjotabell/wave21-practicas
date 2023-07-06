package com.bootcamp.h2.dto.response;

import com.bootcamp.h2.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class StudentListDTO {

    List<StudentDTO> students;

}
