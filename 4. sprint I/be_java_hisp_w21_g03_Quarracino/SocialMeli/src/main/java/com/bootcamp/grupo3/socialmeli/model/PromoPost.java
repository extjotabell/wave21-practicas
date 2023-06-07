package com.bootcamp.grupo3.socialmeli.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PromoPost extends Post{
    private boolean hasPromo;
    private double discount;

    public PromoPost(int id, int userId, LocalDate date, Product product, int category, double price, boolean hasPromo, double discount) {
        super(id, userId, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
