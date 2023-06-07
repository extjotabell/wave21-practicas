package com.linktracker.linktracker.Entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LinkEntity {
    private Integer LinkId;
    private String url;
    private String maskedUrl;
    private Integer redirectCount;
    private Boolean isInvalid;
    private String password;
}
