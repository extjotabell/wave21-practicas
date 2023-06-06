package com.example.be_java_hisp_w21_g1.Utils;

import com.example.be_java_hisp_w21_g1.DTO.Request.PostProductDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.PostBySellerDTO;
import com.example.be_java_hisp_w21_g1.Model.Post;

import java.util.List;

public class Mapper {
    public static Post DTOtoPost(PostProductDTO postProductDTO, int post_id){
        return new Post(
                post_id,
                postProductDTO.getDate(),
                postProductDTO.getProduct(),
                postProductDTO.getCategory(),
                postProductDTO.getPrice());
    }

    public static PostBySellerDTO SellerPostToDTO(List<Post> sellerPost, int user_id){
        return new PostBySellerDTO(user_id,sellerPost);
    }
}
