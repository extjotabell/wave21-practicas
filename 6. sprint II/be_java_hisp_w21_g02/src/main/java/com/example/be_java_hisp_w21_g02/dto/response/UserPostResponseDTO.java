package com.example.be_java_hisp_w21_g02.dto.response;

import com.example.be_java_hisp_w21_g02.dto.PostDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@ToString
public class UserPostResponseDTO {
    private int userId;
    private List<PostDTO> posts;
}
