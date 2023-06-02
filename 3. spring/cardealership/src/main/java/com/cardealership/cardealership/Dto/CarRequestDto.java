package com.cardealership.cardealership.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarRequestDto {
    private String name;
    private String model;
    private String brand;
    private Double price;
}
