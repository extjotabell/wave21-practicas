package com.cardealership.cardealership.Entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    private Long id;
    private String name;
    private String model;
    private String brand;
    private Double price;

}
