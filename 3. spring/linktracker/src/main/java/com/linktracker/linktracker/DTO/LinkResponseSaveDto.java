package com.linktracker.linktracker.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LinkResponseSaveDto {
    private Integer LinkId;
    private String url;
    private String maskedUrl;
}
