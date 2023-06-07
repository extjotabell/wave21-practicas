package com.example.be_java_hisp_w21_g1.Service;

import com.example.be_java_hisp_w21_g1.DTO.Request.FollowPostDTO;
import com.example.be_java_hisp_w21_g1.DTO.Request.PostProductDTO;
import com.example.be_java_hisp_w21_g1.DTO.Request.ProductInSaleDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.*;

public interface IUserService {
    public FollowersCountDTO getFollowersCount(int idUser);
    public FollowerListDTO getFollowersList(int idUser, String order);
    public FollowedListDTO getFollowedList(int idUser, String order);

    boolean unFollow(FollowPostDTO followPostDTO);

    boolean follow(FollowPostDTO followPostDTO);

    PostBySellerDTO listPostsBySeller(int userId, String alfOrder);

    void createPost(PostProductDTO postProductDTO);
    public void saveProductInSale(ProductInSaleDTO dto);

    PromoProductDto getPromoProductCount(int userId);
}
