package com.sprint.be_java_hisp_w21_g04.service.post;

import com.sprint.be_java_hisp_w21_g04.dto.request.PromoPostRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.*;

import java.util.List;

public interface IPostService {

    ResponseDto post(PostRequestDto post);

    ResponseDto post(PromoPostRequestDto postPromo);

    PromoPostCountProductsDto getPromoPostCountProducts(int userId);

    List<PostResponseDto> getAll();

    SellerFollowedListPostResponseDto sellerFollowedListPosts(int user_id, String order);
}
