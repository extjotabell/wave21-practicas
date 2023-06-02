package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeopleDTO {
    private String name;
    private String lastName;
    private int age;
    private List<Integer> codeSymptom;

    public PeopleDTO(String charlie, String schiaffino, int age, int[] ints) {
    }
}
