package com.sprint.be_java_hisp_w21_g04.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FollowersResponseDto {

    private int userId;
    private String userName;
    private List<UserResponseDto> followers;

}
