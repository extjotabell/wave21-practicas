package com.example.be_java_hisp_w21_g02.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {
    private String errorMessage;
    private HttpStatus status;
}