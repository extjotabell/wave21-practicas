package com.example.be_java_hisp_w21_g1.DTO.Response;

import com.example.be_java_hisp_w21_g1.Model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class PostDTO {
    private int user_id;
    private int post_id;

    @JsonFormat(pattern="dd-MM-yyyy")
    @NotNull(message = "The date cannot be null")
    private LocalDate date;

    private Product product;
    private int category;
    private double price;

}
