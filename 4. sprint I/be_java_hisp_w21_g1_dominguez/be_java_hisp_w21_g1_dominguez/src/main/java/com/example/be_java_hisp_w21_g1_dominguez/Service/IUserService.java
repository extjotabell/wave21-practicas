package com.example.be_java_hisp_w21_g1_dominguez.Service;

import com.example.be_java_hisp_w21_g1_dominguez.DTO.Request.FollowPostDTO;
import com.example.be_java_hisp_w21_g1_dominguez.DTO.Request.PostProductDTO;
import com.example.be_java_hisp_w21_g1_dominguez.DTO.Request.PromoPostDTO;
import com.example.be_java_hisp_w21_g1_dominguez.DTO.Response.FollowedListDTO;
import com.example.be_java_hisp_w21_g1_dominguez.DTO.Response.FollowerListDTO;
import com.example.be_java_hisp_w21_g1_dominguez.DTO.Response.FollowersCountDTO;
import com.example.be_java_hisp_w21_g1_dominguez.DTO.Response.PostBySellerDTO;

public interface IUserService {
    public FollowersCountDTO getFollowersCount(int idUser);
    public FollowerListDTO getFollowersList(int idUser, String order);
    public FollowedListDTO getFollowedList(int idUser, String order);

    boolean unFollow(FollowPostDTO followPostDTO);

    boolean follow(FollowPostDTO followPostDTO);

    PostBySellerDTO listPostsBySeller(int userId, String alfOrder);

    void createPost(PostProductDTO postProductDTO);
    void createPromoPost(PromoPostDTO promoPostDTO);
}
