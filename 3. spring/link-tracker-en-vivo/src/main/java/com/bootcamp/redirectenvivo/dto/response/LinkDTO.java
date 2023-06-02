package com.bootcamp.redirectenvivo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LinkDTO {
    private int linkId;
    private String url;
    private Boolean isActive;
    private int counter;
}