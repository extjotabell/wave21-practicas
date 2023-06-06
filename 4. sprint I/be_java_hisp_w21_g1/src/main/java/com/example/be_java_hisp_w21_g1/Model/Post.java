package com.example.be_java_hisp_w21_g1.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

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

    public boolean isLatestPost(LocalDate currentDate){
        return (getLocalDate().isAfter(currentDate.minusWeeks(2))
                && getLocalDate().isBefore(currentDate.plusDays(1))
        );
    }
}
