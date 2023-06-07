package com.linktracker.linktracker.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LinkResponseDto {
    private Integer LinkId;
    private String url;
    private String maskedUrl;
    private Integer redirectCount;
    private Boolean isInvalid;
    private String password;
}
