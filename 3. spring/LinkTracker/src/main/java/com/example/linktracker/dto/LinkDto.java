package com.example.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class LinkDto {
    private Long id;
    private String url;
    private Integer count;
    private Boolean status;
}
