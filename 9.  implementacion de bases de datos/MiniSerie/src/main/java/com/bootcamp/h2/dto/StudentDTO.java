package com.bootcamp.h2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Long idStudent;
    private String firstName;
    private String lastName;
    private String dni;
}
