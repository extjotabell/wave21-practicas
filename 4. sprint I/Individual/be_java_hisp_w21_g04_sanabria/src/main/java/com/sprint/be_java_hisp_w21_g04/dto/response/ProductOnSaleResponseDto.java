package com.sprint.be_java_hisp_w21_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sprint.be_java_hisp_w21_g04.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductOnSaleResponseDto {
     private int userId;
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
     private LocalDate date;
     private Product product;
     private int category;
     private double price;
     private boolean hasPromo;
     private double discount;
}
