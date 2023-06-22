package com.example.be_java_hisp_w21_g1.DTO.Response;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @NotNull(message = "Product_id can't be null")
    @PositiveOrZero( message = "Product_id can't be less than 0")
    private Integer product_id;

    @NotNull (message = "Product name can't be null")
    @Size(max = 40, message = "Product name can't be longer than 40 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Product name can't contain special characters or be empty")
    private String product_name;

    private String type;

    @NotNull (message = "Brand name can't be empty")
    @Size(max = 25, message = "Brand name can't be longer than 25 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Brand name can't contain special characters")
    private String brand;

    @NotNull(message = "Color can't be null")
    @Size(max = 15, message = "Color can't be longer than 15 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Color can't contain special characters")
    private String color;

    @Size(max = 80, message = "Notes can't be longer than 80 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "Notes can't contain special characters")
    private String notes;
}
