package com.mercadolibre.redireclinks.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LinkRequestDTO {
    private String originalUrl;
    private String password;
}
