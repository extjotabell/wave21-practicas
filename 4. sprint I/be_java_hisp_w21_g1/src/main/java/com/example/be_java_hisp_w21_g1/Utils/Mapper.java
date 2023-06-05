package com.example.be_java_hisp_w21_g1.Utils;

import com.example.be_java_hisp_w21_g1.DTO.Request.PostProductDTO;
import com.example.be_java_hisp_w21_g1.Model.Post;

public class Mapper {
    public static Post DTOtoPost(PostProductDTO postProductDTO, int post_id){
        return new Post(
                post_id,
                postProductDTO.getDate(),
                postProductDTO.getProduct(),
                postProductDTO.getPrice(),
                postProductDTO.getCategory());
    }
}
