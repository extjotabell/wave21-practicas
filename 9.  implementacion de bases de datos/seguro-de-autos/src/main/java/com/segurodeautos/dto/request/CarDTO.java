package com.segurodeautos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter @Setter
@AllArgsConstructor
public class CarDTO {
    private String licensePlate;
    private String carBrand;
    private String model;
    private LocalDate manufactureYear;
    private int numWheels;
    private Set<AccidentDTO> accidents;
}
