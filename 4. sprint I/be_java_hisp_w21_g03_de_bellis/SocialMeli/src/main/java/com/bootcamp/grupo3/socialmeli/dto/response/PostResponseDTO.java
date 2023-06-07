package com.bootcamp.grupo3.socialmeli.dto.response;

import com.bootcamp.grupo3.socialmeli.dto.request.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDate;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public record PostResponseDTO (
  int postId,
  int userId,
  @JsonFormat(pattern="dd-MM-yyyy")
  LocalDate date,
  ProductDTO product,
  int category,
  double price
  ) {
}
