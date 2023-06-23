package com.sprint.be_java_hisp_w21_g04.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sprint.be_java_hisp_w21_g04.entity.Product;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.*;
import lombok.*;

import jakarta.validation.Valid;

import java.time.LocalDate;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDto {
     @NotNull(message = "El id del usuario no puede estar vacío.")
     @Positive(message = "El id del usuario debe ser mayor a cero.")
     private Integer userId;
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
     @NotNull(message = "La fecha no puede estar vacía.")
     private LocalDate date;
     private @Valid Product product;
     @NotNull(message = "La categoria no puede estar vacía.")
     private Integer category;
     @NotNull(message = "El precio no puede estar vacío.")
     @DecimalMax(value = "10000000", message = "El precio no puede ser mayor a 10000000")
     private Double price;
}
