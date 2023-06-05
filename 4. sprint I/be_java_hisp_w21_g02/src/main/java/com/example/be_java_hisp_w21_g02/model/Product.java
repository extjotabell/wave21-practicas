package com.example.be_java_hisp_w21_g02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private int id;
    private LocalDate publishDate;
    private String notes;
    private String type;
    private String brand;
}
