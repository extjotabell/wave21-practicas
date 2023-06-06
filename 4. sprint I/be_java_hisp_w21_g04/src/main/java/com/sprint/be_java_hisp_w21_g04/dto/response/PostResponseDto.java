package com.sprint.be_java_hisp_w21_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sprint.be_java_hisp_w21_g04.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {
    private int user_id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product product;
    private int category;
    private double price;
}
