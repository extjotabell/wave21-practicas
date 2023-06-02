package com.bootcamp.blogenvivo.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseErrorDTO {

    private HttpStatus statuscode;
    private String message;

}