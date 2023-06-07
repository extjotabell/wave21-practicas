package com.sprint.be_java_hisp_w21_g04.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserNotFoundDto {
    private String message;
    private int statusCode;
}
