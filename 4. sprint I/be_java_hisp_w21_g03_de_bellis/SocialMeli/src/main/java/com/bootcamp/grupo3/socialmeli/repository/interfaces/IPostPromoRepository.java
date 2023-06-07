package com.bootcamp.grupo3.socialmeli.repository.interfaces;

import com.bootcamp.grupo3.socialmeli.model.PostPromo;

import java.util.List;

public interface IPostPromoRepository {
    int save(PostPromo p);
    List<Integer> findAllPromosByUser(int userId);
}
