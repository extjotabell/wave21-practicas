package com.sprint.be_java_hisp_w21_g04.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FollowersResponseDto {

    private int user_id;
    private String user_name;
    private List<UserResponseDto> followers;

}
