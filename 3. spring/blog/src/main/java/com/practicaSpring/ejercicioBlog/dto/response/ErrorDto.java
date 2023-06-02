package com.practicaSpring.ejercicioBlog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDto {

    String message;
    Integer code;
}
