package com.linktracker.linktracker.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LinkRequestDto {
    private String maskedUrl;
    private String password;
}
