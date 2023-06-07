package com.bootcamp.grupo3.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowedPromoListDTO {
    @JsonProperty("user_id")
    private int id;
    @JsonProperty("user_name")
    private String name;
    @JsonProperty("promotional_posts")
    private List<PromoPostResponseDTO> promotionalPosts = new ArrayList<>();
}
