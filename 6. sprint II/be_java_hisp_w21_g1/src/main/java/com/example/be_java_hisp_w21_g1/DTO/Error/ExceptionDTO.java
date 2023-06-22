package com.example.be_java_hisp_w21_g1.DTO.Error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExceptionDTO {
    String message;
    List<String> allErrors;
}
