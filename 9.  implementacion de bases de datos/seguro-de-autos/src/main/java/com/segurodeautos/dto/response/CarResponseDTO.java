package com.segurodeautos.dto.response;

import com.segurodeautos.dto.request.AccidentDTO;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.Set;

@Getter @Setter
public class CarResponseDTO {
    private Long id;
    private String licensePlate;
    private String carBrand;
    private String model;
    private LocalDate manufactureYear;
    private int numWheels;
    private Set<AccidentDTO> accidents;
}