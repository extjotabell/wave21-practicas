package com.bootcamp.redirectenvivo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MetricsResponseDTO {
    private String url;
    private int numberOfRedirections;
}
