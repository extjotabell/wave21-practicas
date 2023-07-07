package com.segurodeautos.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AccidentDTO {
    private LocalDate accidentDate;
    private Double economicLost;
}
