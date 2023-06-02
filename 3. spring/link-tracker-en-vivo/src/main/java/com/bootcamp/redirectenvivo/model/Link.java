package com.bootcamp.redirectenvivo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private int linkId;
    private String url;
    private Boolean isActive;
    private int counter;
    private String password;
}