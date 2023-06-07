package com.example.be_java_hisp_w21_g1.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Post {
    private int userId;
    private int postId;
    private LocalDate localDate;
    private Product product;
    private int category;
    private Double price;
    // Atributos de productos en promo
    private boolean has_promo;
    private Double discount;

    public boolean isLatestPost(LocalDate currentDate){
        return (getLocalDate().isAfter(currentDate.minusWeeks(2))
                && getLocalDate().isBefore(currentDate.plusDays(1))
        );
    }
}
