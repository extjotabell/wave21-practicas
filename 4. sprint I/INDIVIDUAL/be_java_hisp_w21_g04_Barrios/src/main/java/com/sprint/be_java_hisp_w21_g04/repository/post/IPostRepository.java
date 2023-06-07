package com.sprint.be_java_hisp_w21_g04.repository.post;

import com.sprint.be_java_hisp_w21_g04.entity.Post;

import java.util.List;

public interface IPostRepository {
    void post(Post post);

    void promoPost(Post promoPost);

    List<Post> getAll();

    public List<Post> getSellerFollowed(int user_id);


}
