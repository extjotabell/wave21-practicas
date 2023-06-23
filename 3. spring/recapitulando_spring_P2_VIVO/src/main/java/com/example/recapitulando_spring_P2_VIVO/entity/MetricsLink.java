package com.example.recapitulando_spring_P2_VIVO.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MetricsLink {
    Integer linkId;
    String linkName;
    Integer redirectCount;
}
