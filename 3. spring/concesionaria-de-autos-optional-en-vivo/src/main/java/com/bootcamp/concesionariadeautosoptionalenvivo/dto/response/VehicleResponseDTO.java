package com.bootcamp.concesionariadeautosoptionalenvivo.dto.response;

import lombok.Data;
import lombok.Setter;
import java.time.LocalDateTime;

@Data
@Setter
public class VehicleResponseDTO {
    private int id;
    private String brand;
    private String model;
    private LocalDateTime manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private int countOfOwners;
}
