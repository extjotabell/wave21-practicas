package com.sprint.be_java_hisp_w21_g04.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@ToString
@EqualsAndHashCode
public class SellerFollowedListPostResponseDto {
    private int userId;
    private List<PostResponseDto> posts;
}
