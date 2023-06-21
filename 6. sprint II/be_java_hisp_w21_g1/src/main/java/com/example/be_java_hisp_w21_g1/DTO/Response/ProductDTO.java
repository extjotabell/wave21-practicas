package com.example.be_java_hisp_w21_g1.DTO.Response;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotNull(message = "Product_id can't be null")
    @PositiveOrZero( message = "Product_id can't be less than 0")
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
