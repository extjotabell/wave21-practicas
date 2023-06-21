package com.example.be_java_hisp_w21_g02.dto.response;

import com.example.be_java_hisp_w21_g02.dto.PostDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class UserPostResponseDTO {
    private int userId;
    private List<PostDTO> posts;
}
