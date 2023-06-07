package com.sprint.be_java_hisp_w21_g04.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sprint.be_java_hisp_w21_g04.entity.Product;
import lombok.*;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostRequestDto {
     private int userId;
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
     private LocalDate date;
     private Product product;
     private int category;
     private double price;
}
