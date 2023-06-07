package com.bootcamp.grupo3.socialmeli.dto.response;

import com.bootcamp.grupo3.socialmeli.dto.request.PostOnSaleDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PostOnSaleUserDTO {
    private int userId;
    private String userName;
    private List<PostOnSaleDTO> posts;
}
