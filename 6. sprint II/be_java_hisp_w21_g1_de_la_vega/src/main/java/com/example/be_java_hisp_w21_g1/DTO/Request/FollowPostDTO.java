package com.example.be_java_hisp_w21_g1.DTO.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FollowPostDTO {
    @NotNull(message = "User_id can't be empty")
    @Positive(message = "User_id can't be less than 0")
    private Integer userId;
    private int userIdToFollow;
}
