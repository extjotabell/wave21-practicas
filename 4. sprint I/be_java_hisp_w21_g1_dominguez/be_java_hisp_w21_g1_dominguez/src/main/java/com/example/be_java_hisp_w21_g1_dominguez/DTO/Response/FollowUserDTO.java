package com.example.be_java_hisp_w21_g1_dominguez.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FollowUserDTO {
    private int user_id;
    private String user_name;
}
