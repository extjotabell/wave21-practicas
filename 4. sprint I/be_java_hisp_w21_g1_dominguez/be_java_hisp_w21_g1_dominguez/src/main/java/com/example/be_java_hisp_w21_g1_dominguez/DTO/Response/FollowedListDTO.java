package com.example.be_java_hisp_w21_g1_dominguez.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowedListDTO {
    private int user_id;
    private List<FollowUserDTO> followed;

    public FollowedListDTO(int idUser, String userName, List<FollowUserDTO> followedList) {
    }
}
