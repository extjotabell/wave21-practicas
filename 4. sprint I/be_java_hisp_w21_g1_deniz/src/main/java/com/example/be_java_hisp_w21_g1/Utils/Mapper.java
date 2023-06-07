package com.example.be_java_hisp_w21_g1.Utils;

import com.example.be_java_hisp_w21_g1.DTO.Request.PostProductDTO;
import com.example.be_java_hisp_w21_g1.DTO.Request.PostProductPromoDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.PostBySellerDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.PostDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.PromoProductsCountDTO;
import com.example.be_java_hisp_w21_g1.Model.Post;
import com.example.be_java_hisp_w21_g1.Model.User;

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

    public static Post DTOtoPost(PostProductDTO postProductDTO, int postId) {
        return new Post(
                postProductDTO.getUser_id(),
                postId,
                postProductDTO.getDate(),
                postProductDTO.getProduct(),
                postProductDTO.getCategory(),
                postProductDTO.getPrice()
        );
    }

    public static Post PostPromoDTOToPost(PostProductPromoDTO postProductPromoDTO, int postId) {
        return new Post(
                postProductPromoDTO.getUser_id(),
                postId,
                postProductPromoDTO.getDate(),
                postProductPromoDTO.getProduct(),
                postProductPromoDTO.getCategory(),
                postProductPromoDTO.getPrice(),
                postProductPromoDTO.getHas_promo(),
                postProductPromoDTO.getDiscount()
        );
    }

    public static PromoProductsCountDTO SellerInfoTOPromoProductsCount(User user, int countProducts) {
        return new PromoProductsCountDTO(
                user.getUser_id(),
                user.getUser_name(),
                countProducts
        );
    }
}
