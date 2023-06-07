package com.sprint.be_java_hisp_w21_g04.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SellerFollowedListPostResponseDto {
    private int userId;
    private List<PostResponseDto> posts;
}
