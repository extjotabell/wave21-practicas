package com.example.be_java_hisp_w21_g1.Utils;

import com.example.be_java_hisp_w21_g1.DTO.Response.PostBySellerDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.PostDTO;
import com.example.be_java_hisp_w21_g1.Model.Post;

import java.util.List;

public class Mapper {
    public static PostBySellerDTO SellerPostToDTO(List<PostDTO> sellerPost, int user_id){
        return new PostBySellerDTO(user_id,sellerPost);
    }


    public static PostDTO PostToPostDTO(Post post) {
        return new PostDTO(
                post.getUserId(),
                post.getPostId(),
                post.getLocalDate(),
                post.getProduct(),
                post.getCategory(),
                post.getPrice()
        );
    }
}
