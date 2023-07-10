package com.moviesdbhql.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EpisodesDTO {
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private Double rating;
}
