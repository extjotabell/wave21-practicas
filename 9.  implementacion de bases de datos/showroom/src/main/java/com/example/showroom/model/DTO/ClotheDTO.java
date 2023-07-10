package com.example.showroom.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClotheDTO {
    private String name;
    private String color;
    private String size;
    private Double price;
}
