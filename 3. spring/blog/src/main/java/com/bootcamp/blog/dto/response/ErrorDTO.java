package com.bootcamp.blog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class ErrorDTO {

    private String message;
    private int code;

}
