package com.bootcamp.grupo3.socialmeli.dto.request;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record PostPromoDTO (
    String token,
    @JsonFormat(pattern="dd-MM-yyyy")
    LocalDate date,
    ProductDTO product,
    int category,
    double price,
    boolean hasPromo,
    double discount
) {

}
