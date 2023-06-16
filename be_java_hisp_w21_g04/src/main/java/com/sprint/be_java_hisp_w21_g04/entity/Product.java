package com.sprint.be_java_hisp_w21_g04.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Product {

    @NotNull(message = "La id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero.")
    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
