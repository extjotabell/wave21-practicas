package com.bootcamp.grupo3.socialmeli.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class  PostDTO {

    @NotNull(message = "El id del usuario no puede estar vacío.")
    @Positive(message = "El id del usuario debe ser mayor a cero")
    private Integer userId;

    @JsonFormat(pattern="dd-MM-yyyy")
    @NotNull(message = "La fecha no puede estar vacía.")
    private LocalDate date;

    @Valid
    @NotNull(message = "El producto no puede estar vacío.")
    private ProductDTO product;

    @NotNull(message = "La categoría no puede estar vacía.")
    private Integer category;

    @NotNull(message = "El precio no puede estar vacío.")
    @Max(value=10_000_000, message = "El precio máximo por producto es de 10.000.000")
    private Double price;
}
