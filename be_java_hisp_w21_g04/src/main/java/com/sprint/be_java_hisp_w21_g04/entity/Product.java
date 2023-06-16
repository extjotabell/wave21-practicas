package com.sprint.be_java_hisp_w21_g04.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Product {

    @NotNull(message = "La id del producto no puede estar vacío.")
    @Positive(message = "El id del producto debe ser mayor a cero.")
    private int productId;
    @NotNull(message = "El nombre del producto no puede estar vacío.")
    @Size(min = 1, max = 40, message = "La longitud del nombre del producto no puede superar los 40 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El nombre del producto no puede poseer caracteres especiales.")
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
