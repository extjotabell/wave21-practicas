package com.bootcamp.grupo3.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int id;
    private int userId;
    private LocalDate date;
    private Product product;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
    private Collection<Integer> likes = new ArrayList<>();

    public int getLikeSize(){
        return this.likes.size();
    }
}
