package com.segurodeautos.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AccidentDTO {
    private Long id;
    private LocalDate accidentDate;
    private Double economicLost;
}
