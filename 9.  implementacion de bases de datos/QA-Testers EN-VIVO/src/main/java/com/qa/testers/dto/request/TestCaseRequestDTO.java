package com.qa.testers.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor @NoArgsConstructor
public class TestCaseRequestDTO {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer numberOfTries;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate lastUpdate;
}