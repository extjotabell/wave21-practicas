package com.example.be_java_hisp_w21_g1_dominguez.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowerListDTO {
    private int user_id;
    private String user_name;
    private List<FollowUserDTO> followers;
}
