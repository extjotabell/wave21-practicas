package com.bootcamp.LasPerlas.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MessageDTO {
    private int statusCode;
    private String message;
}
