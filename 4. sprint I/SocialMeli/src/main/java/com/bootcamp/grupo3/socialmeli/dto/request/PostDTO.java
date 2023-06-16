package com.bootcamp.grupo3.socialmeli.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Validated
public class  PostDTO {

    @NotNull(message = "El id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero")
    private int userId;

    @JsonFormat(pattern="dd-MM-yyyy")
    @NotNull(message = "La fecha no puede estar vacía.")
    private LocalDate date;

    @Valid
    @NotNull(message = "El producto no puede estar vacío.")
    private ProductDTO product;

    @NotNull(message = "La categoría no puede estar vacía.")
    private int category;

    @NotNull(message = "El precio no puede estar vacío.")
    @Max(value=10_000_000, message = "El precio máximo por producto es de 10.000.000")
    private double price;
}
