package com.example.linktracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private Long id;
    private String url;
    private Integer count;
    private Boolean status;


}
