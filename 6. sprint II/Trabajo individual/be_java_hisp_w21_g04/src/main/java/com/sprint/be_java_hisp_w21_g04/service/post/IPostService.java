package com.sprint.be_java_hisp_w21_g04.service.post;

import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.PostResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.SellerFollowedListPostResponseDto;

import java.util.List;

public interface IPostService {
    void post(PostRequestDto post);
    List<PostResponseDto> getAll();

    SellerFollowedListPostResponseDto sellerFollowedListPosts(int user_id, String order);
}
