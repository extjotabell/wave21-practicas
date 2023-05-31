package com.example.covid.clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private int id;
    private String name;
    private String lastName;
    private int age;
}
