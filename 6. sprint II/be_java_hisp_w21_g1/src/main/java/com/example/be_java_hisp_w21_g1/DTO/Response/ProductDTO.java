package com.example.be_java_hisp_w21_g1.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int product_id;
    private String product_name;
    private String type;
    @NotNull (message = "Brand name can't be empty")
    @Size(max = 25, message = "Brand name can't be longer than 25 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Brand name can't contain special characters")
    private String brand;
    private String color;
    private String notes;
}
