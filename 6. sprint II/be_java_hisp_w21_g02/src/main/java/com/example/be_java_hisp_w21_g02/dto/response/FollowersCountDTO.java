package com.example.be_java_hisp_w21_g02.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class FollowersCountDTO {
    @JsonProperty("user_id")
    private int id;
    @JsonProperty("username")
    private String username;
    private int followersCount;
}
