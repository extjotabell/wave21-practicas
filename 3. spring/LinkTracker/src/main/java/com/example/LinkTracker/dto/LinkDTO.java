package com.example.LinkTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LinkDTO {
    int linkId;
    String url;
    int numberOfRedirects;
    String password;
}
