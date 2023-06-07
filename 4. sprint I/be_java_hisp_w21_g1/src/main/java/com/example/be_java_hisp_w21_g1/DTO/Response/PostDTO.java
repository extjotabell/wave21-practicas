package com.example.be_java_hisp_w21_g1.DTO.Response;

import com.example.be_java_hisp_w21_g1.Model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private int user_id;
    private int post_id;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;

    private Product product;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

    public PostDTO(int user_id, int post_id, LocalDate date, Product product, int category, double price) {
        this.user_id = user_id;
        this.post_id = post_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = false;
        this.discount = 0.0;
    }
}
