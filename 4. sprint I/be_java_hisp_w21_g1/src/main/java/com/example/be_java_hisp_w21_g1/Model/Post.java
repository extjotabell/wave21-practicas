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
    private boolean hasPromo;
    private Double discount;

    public Post(int userId, int postId, LocalDate localDate, Product product, int category, Double price) {
        this.userId = userId;
        this.postId = postId;
        this.localDate = localDate;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = false;
        this.discount = 0.0;
    }

    public boolean isLatestPost(LocalDate currentDate){
        return (getLocalDate().isAfter(currentDate.minusWeeks(2))
                && getLocalDate().isBefore(currentDate.plusDays(1))
        );
    }
}
