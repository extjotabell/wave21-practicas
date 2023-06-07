package com.bootcamp.grupo3.socialmeli.dto.response;

import com.bootcamp.grupo3.socialmeli.dto.request.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromoPostResponseDTO {
    private int postId;
    private int userId;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO product;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
