package com.example.be_java_hisp_w21_g02.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowersCountDTO {
    @JsonProperty("user_id")
    private int id;
    @JsonProperty("username")
    private String username;
    private int followersCount;
}
