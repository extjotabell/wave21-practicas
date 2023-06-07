package com.example.be_java_hisp_w21_g1_dominguez.Utils;

import com.example.be_java_hisp_w21_g1_dominguez.DTO.Request.PostProductDTO;
import com.example.be_java_hisp_w21_g1_dominguez.DTO.Request.PromoPostDTO;
import com.example.be_java_hisp_w21_g1_dominguez.DTO.Response.*;
import com.example.be_java_hisp_w21_g1_dominguez.Model.Post;
import com.example.be_java_hisp_w21_g1_dominguez.Model.PromoPost;

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

    public static PromoPost DTOtoPromoPost(PromoPostDTO promoPostDTO, int postId) {
        return new PromoPost(
                promoPostDTO.getUser_id(),
                postId,
                promoPostDTO.getDate(),
                promoPostDTO.getProduct(),
                promoPostDTO.getCategory(),
                promoPostDTO.getPrice(),
                promoPostDTO.getHas_promo(),
                promoPostDTO.getDiscount()
        );
    }

    public static PromoPostBySellerDTO SellerPromoPostToDTO(int user_id, String username, Long countPromoPost){
        return new PromoPostBySellerDTO(user_id, username, countPromoPost);
    }

    public static CountByFollowedSellerDTO countByFollowedSellerDTO(int user_id, List<FollowUserCountDTO> countByFollowedSellerDTO) {
        return new CountByFollowedSellerDTO(
                user_id,
                countByFollowedSellerDTO
        );
    }
}
