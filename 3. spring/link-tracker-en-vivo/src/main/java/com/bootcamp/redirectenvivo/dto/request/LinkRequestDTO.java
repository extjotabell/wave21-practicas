package com.bootcamp.redirectenvivo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LinkRequestDTO {
    private String url;
    private Boolean isActive;
    private String password;
}
