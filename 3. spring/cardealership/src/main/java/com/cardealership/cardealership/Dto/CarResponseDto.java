package com.cardealership.cardealership.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarResponseDto {
    private String name;
    private String model;
    private Double price;
}
