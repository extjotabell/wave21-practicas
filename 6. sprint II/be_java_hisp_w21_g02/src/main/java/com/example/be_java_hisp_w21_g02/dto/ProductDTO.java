package com.example.be_java_hisp_w21_g02.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Validated
@EqualsAndHashCode
@ToString
public class ProductDTO {

    @Positive(message = "The ProductId must be greater than zero")
    @NotNull(message = "The ProductId field is required")
    private Integer productId;

    @Size(max = 40, message = "The productName length cannot exceed 40 characters.")
    @NotEmpty(message = "The ProductName field is required")
    @Pattern(regexp = "^[a-zA-Z0-9&\\s]*$", message = "The productName field cannot have special characters")
    private String productName;

    @Pattern(regexp = "^[a-zA-Z0-9&\\s]*$", message = "The brand field cannot have special characters")
    @Size(max = 25, message = "The brand length cannot exceed 25 characters.")
    @NotEmpty(message = "The brand field is required")
    private String brand;

    @Pattern(regexp = "^[a-zA-Z0-9&\\s]*$", message = "The type field cannot have special characters")
    @Size(max = 15, message = "The type length cannot exceed 15 characters.")
    @NotEmpty(message = "The type field is required")
    private String type;

    @Size(max = 15, message = "The color field length cannot exceed 15 characters.")
    @NotEmpty(message = "The color field is required")
    @Pattern(regexp = "^[a-zA-Z0-9&\\s]*$", message = "The color field cannot have special characters")
    private String color;

    @Size(max = 80, message = "The notes field length cannot exceed 80 characters.")
    @Pattern(regexp = "^[a-zA-Z0-9&\\s]*$", message = "The notes field cannot have special characters")
    private String notes;
}
