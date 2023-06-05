package com.example.LinkTracker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    public enum Estado {VALIDO, INVALIDO}
    int linkId;
    String url;
    int numberOfRedirects;
    String password;
    Estado estado;
}
