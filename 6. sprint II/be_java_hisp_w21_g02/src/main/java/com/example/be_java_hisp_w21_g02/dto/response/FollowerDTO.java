package com.example.be_java_hisp_w21_g02.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class FollowerDTO {
    private int userId;
    @JsonProperty("user_name")
    private String username;
}
