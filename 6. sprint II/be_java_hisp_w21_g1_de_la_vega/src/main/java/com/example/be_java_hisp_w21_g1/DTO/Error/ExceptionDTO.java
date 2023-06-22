package com.example.be_java_hisp_w21_g1.DTO.Error;

import lombok.*;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExceptionDTO {
    private String message;
    private List<String> allErrors;
}
