package com.example.be_java_hisp_w21_g1_dominguez.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FollowPostDTO {
    int userId;
    int userIdToFollow;
}
