package com.bootcamp.redirectenvivo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseErrorDTO {
    private HttpStatus httpStatus;
    private String message;
}
