package com.sprint.be_java_hisp_w21_g04.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sprint.be_java_hisp_w21_g04.entity.Product;
import lombok.*;

import java.time.LocalDate;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostRequestDto {
     private int user_id;
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
     private LocalDate date;
     private Product product;
     private int category;
     private double price;
}
