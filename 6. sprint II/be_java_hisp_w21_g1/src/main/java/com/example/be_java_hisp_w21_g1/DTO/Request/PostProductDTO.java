package com.example.be_java_hisp_w21_g1.DTO.Request;

import com.example.be_java_hisp_w21_g1.DTO.Response.ProductDTO;
import com.example.be_java_hisp_w21_g1.Model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostProductDTO {

  @NotEmpty(message = "El  id no puede estar vacío.")
  @PositiveOrZero(message = "El id debe ser mayor a cero")
  int user_id;

  @JsonFormat(pattern="dd-MM-yyyy")
  @NotNull(message = "The date cannot be null")
  LocalDate date;

  @Valid ProductDTO product;
  int category;
  Double price;
}
