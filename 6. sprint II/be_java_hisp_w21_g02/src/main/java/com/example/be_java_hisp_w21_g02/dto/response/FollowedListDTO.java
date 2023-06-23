package com.example.be_java_hisp_w21_g02.dto.response;
import lombok.*;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class FollowedListDTO {

    private int userId;
    private String userName;
    private List<FollowerDTO> followed;

}
