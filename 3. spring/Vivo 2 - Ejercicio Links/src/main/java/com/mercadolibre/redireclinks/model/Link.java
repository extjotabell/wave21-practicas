package com.mercadolibre.redireclinks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {

    private int linkId;
    private String originalUrl;
    private String password;
    private int redirectCount;
    private boolean isvalid;

}
